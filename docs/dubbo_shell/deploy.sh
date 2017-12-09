#!/bin/bash
# 脚本放在${instance}目录下
# usage:
# deploy.sh 20171208192100

echo "begin deploy ..."

instance=$(basename `pwd`)
echo "instance=" ${instance}
version=$1
echo "version=" ${version}
if [ "${version}" = "" ]; then
   echo "please input version!"
   exit 1
fi

#停止coros各个服务
echo "/mnt/${instance}/stop_all.sh"
/mnt/${instance}/stop_all.sh
#查看服务是否停止
echo "ps -ef|grep coros"
ps -ef|grep coros
#删除/mnt/${instance}/rest user data device
echo "rm -rf  /mnt/${instance}/rest user data device"
rm -rf  /mnt/${instance}/rest
rm -rf  /mnt/${instance}/user
rm -rf  /mnt/${instance}/data
rm -rf  /mnt/${instance}/device
#拷贝第一个实例的jar到当/mnt/${instance}/目录
echo "cp -r /mnt/upload-jar/${instance}/${version}/*  /mnt/${instance}/"
cp -r /mnt/upload-jar/${instance}/${version}/*  /mnt/${instance}/
#启动coros服务
sleep 3
echo "/mnt/${instance}/restart_all.sh"
/mnt/${instance}/restart_all.sh
sleep 3
#查看服务是否启动
echo "ps -ef|grep coros"
ps -ef|grep coros

echo "end deploy ..."
