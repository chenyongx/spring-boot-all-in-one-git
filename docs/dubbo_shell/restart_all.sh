#!/bin/bash
# 脚本放在dubbo目录下
# usage:
# sh ./restart_all.sh

sh ./start.sh restart user
sh ./start.sh restart data
sh ./start.sh restart device
sh ./start.sh restart rest