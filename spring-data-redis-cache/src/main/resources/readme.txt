启动服务器
d:
cd D:\soft\Redis-x64-3.2.100
redis-server.exe redis.windows.conf
或者
D:\soft\Redis-x64-3.2.100\redis-server.exe D:\soft\Redis-x64-3.2.100\redis.windows.conf

客户端连接
D:\soft\Redis-x64-3.2.100\redis-cli.exe -h 127.0.0.1 -p 6379

以下实例同时执行 10000 个请求来检测性能
D:\soft\Redis-x64-3.2.100\redis-benchmark -n 10000  -q
