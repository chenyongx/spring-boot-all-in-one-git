#!/bin/bash
# 脚本放在dubbo目录下
# usage:
# backup.sh 20171208195600

echo "begin backup ..."

instance=$(basename `pwd`)
echo "instance=" ${instance}
version=$1
echo "version=" ${version}
if [ "${version}" = "" ]; then
   echo "please input version!"
   exit 1
fi

#1 分实例分微服务全量备份（每个微服务在50M左右），备份整个微服务，方便回退，不涉及变更的微服务不备份
#2 备份目录：/backup/dubbo/20171207103000/微服务
#20171207103000: 表示变更开始的时间戳，为区分一天有多次变更的情况；
#3 命令如下：

echo "mkdir -p /backup/${instance}/${version}"
mkdir -p /backup/${instance}/${version}
echo "cp -r /mnt/${instance}/ /backup/${instance}/${version}/"
cp -r /mnt/${instance}/ /backup/${instance}/${version}/

echo "end backup ..."



