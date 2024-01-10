# gid-~~分布式~~ID 生成器

## 实现功能

-   [x] 使用内存号段模式生成自增 ID
-   [x] 雪花 ID 生成算法
-   [x] 解决雪花 ID 时钟回拨问题
-   [x] HTTP 接口调用
-   [ ] gRPC 调用

## 使用方法

启动项目

[http 接口](https://apifox.com/apidoc/shared-c6883ac2-816a-4fed-ac74-abeb51f5ed3b)如下:

https://apifox.com/apidoc/shared-c6883ac2-816a-4fed-ac74-abeb51f5ed3b

## 性能测试

本机使用 Apache JMeter 测试, 测试文件见[gid-jmx](./gid.jmx)

号段大小为 1000 的情况下, 自增 ID 接口 QPS 为 4000

<img src="https://cdn.jsdelivr.net/gh/Guo-Chenxu/imgs@main/imgs/202401102109225.png"/>

雪花 ID 接口 QPS 为 4200

<img src="https://cdn.jsdelivr.net/gh/Guo-Chenxu/imgs@main/imgs/202401102111283.png"/>

## 参考资料

[Leaf——美团点评分布式 ID 生成系统](https://tech.meituan.com/2017/04/21/mt-leaf.html)
