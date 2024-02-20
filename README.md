# gid-分布式唯一 ID 生成器

## 实现功能

-   [x] 使用内存号段模式生成自增 ID
-   [x] 雪花 ID 生成算法
-   [x] 解决雪花 ID 时钟回拨问题
-   [x] HTTP 接口调用
-   [x] gRPC 调用

## 使用方法

[http 接口文档 (swagger)](https://gid.chenxutalk.top/swagger-ui/index.html)

[http 接口 (apifox)](https://apifox.com/apidoc/shared-c6883ac2-816a-4fed-ac74-abeb51f5ed3b)

[gRPC 接口规范](./src/main/proto/gid.proto)

[gRPC 调用范例](./src/test/java/com/guochenxu/gid/GRPCTest.java)

## 性能测试

使用 K6 测试, 100 个虚拟用户循环 1 分钟, 测试文件见[auto-id.js](test/auto-id.js) 和 [snowId.js](test/snowId.js)

### 本地测试 (Windows 10, R7-5800HS, 16G)

号段大小为 1000 的情况下, 自增 ID 接口 QPS 为 12000

<img src="https://cdn.jsdelivr.net/gh/Guo-Chenxu/imgs@main/imgs/202402131743101.png"/>

雪花 ID 接口 QPS 为 12000

<img src="https://cdn.jsdelivr.net/gh/Guo-Chenxu/imgs@main/imgs/202402131745389.png"/>

### 服务器测试 (腾讯云, Ubuntu 20.04, 2C2G)

号段大小为 1000 的情况下, 自增 ID 接口 QPS 为 1550

<img src="https://cdn.jsdelivr.net/gh/Guo-Chenxu/imgs@main/imgs/202402131812227.png"/>

雪花 ID 接口 QPS 为 1590

<img src="https://cdn.jsdelivr.net/gh/Guo-Chenxu/imgs@main/imgs/202402131814699.png"/>

## 参考资料

[Leaf——美团点评分布式 ID 生成系统](https://tech.meituan.com/2017/04/21/mt-leaf.html)
