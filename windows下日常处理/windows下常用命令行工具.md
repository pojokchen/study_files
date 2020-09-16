# windows下常用命令行工具

## 1.查看特定端口连接情况

```
netstat -ano -p tcp|findstr "8899"  --查看特定8899端口的tcp连接情况

#各参数详情
-a： 显示所有连接和监听端口
-n:  以数字形式显示地址和端口号
-o:  显示与每个连接相关的所属进程 ID 
-p(proto): 显示该项指定协议的连接(可选协议TCP 、UDP 、TCPv6 或 UDPv6)。如果与 -s 选项一起使用以显示按协议统计信息(可选协议为:IP 、IPv6 、ICMP 、ICMPv6 、TCP 、TCPv6 、UDP 或 UDPv6)
-r:  显示路由表
```

![image-20200819163050277](C:\Users\pojok\AppData\Roaming\Typora\typora-user-images\image-20200819163050277.png)

