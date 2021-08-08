# 数据库中间件之Sharding Sphere

## 1.简介

​		`Sharding-JDBC` 最早是当当网内部使用的一款分库分表框架，到2017年的时候才开始对外开源，这几年在大量社区贡献者的不断迭代下，功能也逐渐完善，现已更名为 `ShardingSphere`，2020年4⽉16⽇正式成为 `Apache` 软件基⾦会的顶级项⽬。

​		`ShardingSphere`现已成为一套开源分布式数据库解决方案组成的生态圈，它由 JDBC、Proxy 和 Sidecar（规划中）这 3 款既能够独立部署，又支持混合部署配合使用的产品组成。它们均提供标准化的数据水平扩展、分布式事务和分布式治理等功能，可适用于如 Java 同构、异构语言、云原生等各种多样化的应用场景。

​		其整个框架的架构如下(引用自官网)：

![ShardingSphere Scope](数据库中间据之ShardingSphere.assets/shardingsphere-scope_cn.png)

### 1.1 ShardingSphere-JDBC

