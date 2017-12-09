#!/bin/bash
# 脚本放在dubbo目录下
# usage:
# 如果文件格式有问题，先执行dos2unix start.sh，修改文件格式
# sh ./start.sh start rest/data/user/device
# sh ./start.sh stop rest/data/user/device
# sh ./start.sh restart rest/data/user/device

now=$(date +%Y%m%d)
#进入jar目录
microServiceName=$2
home_dir=`pwd`
command="java -Xms256m -Xmx512m -jar ${home_dir}/${microServiceName}/coros-${microServiceName}-2.0.jar"
log_dir=${home_dir}-log/${microServiceName}
mkdir -p ${log_dir}
log_file_url="${log_dir}/catalina.${now}.out"

start(){
    if [ "$log_file_url" != "" ]; then
        exec $command  > "$log_file_url" &
    else
        exec $command &
    fi
}

stop(){
 ps -ef | grep "$command" | awk '{print $2}' | while read pid
 do
    C_PID=$(ps --no-heading $pid | wc -l)
    echo "current PID=$pid"
    if [ "$C_PID" == "1" ]; then
        echo "PID=$pid killing"
        kill -9 $pid
        echo "PID=$pid killed"
    else
        echo "PID=$pid not exist"
    fi
 done
}


case "$1" in
start)
start
;;
stop)
stop
;;
restart)
stop
start
;;
*)
printf 'Usage: %s {start|stop|restart}\n' "$prog"
exit 1
;;
esac
