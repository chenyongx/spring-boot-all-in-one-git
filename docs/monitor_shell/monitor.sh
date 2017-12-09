#!/bin/sh
# 自动监控进程脚本并且执行重启操作

# 日志输出
monitor_home=/home/monitor_shell
GetPageInfo=/dev/null
log_file=${monitor_home}/coros_monitor.log

echo "hello "

monitor()
{
    echo "monitor args: "$*
    argus=$*
    # 进程名称
    process_name=` echo ${argus} | awk -F\| '{print $1}'`
    # 启动程序
    start_shell=` echo ${argus} | awk -F\| '{print $2}'`
    # 定义要监控的页面地址
    monitor_url=`echo ${argus} | awk -F\| '{print $3}'`
    # url返回碼
    check_url_result_code=`echo ${argus} | awk -F\| '{print $4}'`

    # 获取tomcat进程ID
    TomcatID=$(ps -ef |grep "${process_name}"|grep -v 'grep'|awk '{print $2}')

  echo "[$(date +'%F %H:%M:%S')][info]开始监控${process_name}"
  if [[ ${TomcatID} ]];then # 这里判断进程是否存在
    echo "[$(date +'%F %H:%M:%S')][info]当前进程ID为:${TomcatID}"
    if [ "${monitor_url}" !=  "" ]; then
        echo "[$(date +'%F %H:%M:%S')][info]继续检测页面${monitor_url}"
        # 检测是否启动成功(成功的话页面会返回状态"200")
        result_code=$(curl -s -o ${GetPageInfo} -m 10 --connect-timeout 10 ${monitor_url} -w %{http_code})
        if [ ${result_code} -eq ${check_url_result_code} ];then
            echo "[$(date +'%F %H:%M:%S')][info]页面返回码为${result_code}, 进程启动成功,测试页面正常"
        else
            echo "[$(date +'%F %H:%M:%S')][error]页面出错,请注意,状态码为${result_code},错误日志已输出到${GetPageInfo}"
            echo "[$(date +'%F %H:%M:%S')][error]页面访问出错,开始重启"
        fi
    fi

  else
    echo "[$(date +'%F %H:%M:%S')][error]进程不存在!开始自动启动"
    echo "[$(date +'%F %H:%M:%S')][info]${start_shell},请稍候"
    ${start_shell}
  fi
  echo "------------------------------"
}


cat ${monitor_home}/inputList.txt | while read line
do
    monitor ${line} >> ${log_file}
done
