#!/bin/bash
# 脚本放在dubbo目录下
# usage:
# sh ./start.sh start rest
# sh ./start.sh stop rest
# sh ./start.sh restart rest

now=$(date +%Y%m%d)
#进入jar目录
microServiceName=$2
command="java -Xms256m -Xmx512m -jar /mnt/dubbo/${microServiceName}-2.0.jar"
log_dir=/mnt/logs/run/${microServiceName}
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
    echo "当前PID=$pid"
    if [ "$C_PID" == "1" ]; then
        echo "PID=$pid 准备结束"
        kill -9 $pid
        echo "PID=$pid 已经结束"
    else
        echo "PID=$pid 不存在"
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