#!/bin/bash
# 脚本放在dubbo目录下
# usage:
# sh ./restart_all.sh

sh ./start.sh stop user
sh ./start.sh stop data
sh ./start.sh stop device
sh ./start.sh stop rest