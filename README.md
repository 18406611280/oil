## 平台简介

**注意：lib.rar 对应的是金仓数据库的jar包**

依次绑定host：

127.0.0.1 eureka7001.com

127.0.0.1 gateway.com

如果要使用eureka集群，请依次绑定eureka7002.com,eureka7003.com后修改各项目中的注释部分

```
grainoil-cloud
|
├──grainoil-common --通用包
|  |
|  ├──grainoil-common-core --核心工具包
|  |
|  ├──grainoil-common-redis --redis工具包
|  |
|  ├──grainoil-common-log --日志工具包
|  |
|  ├──grainoil-common-auth --权限工具包
|
├──grainoil-config --cloud统一配置中心
|
├──grainoil-eureka --注册中心
|
├──grainoil-gateway --网关
|
├──grainoil-service-api --服务api模块
|  |
|  ├──grainoil-system-api --系统业务api
|
├──grainoil-service --微服务
|  |
|  ├──grainoil-system --系统业务
|  |
|  ├──grainoil-auth --授权中心
|  |
|  ├──grainoil-gen --代码生成
|  |
|  ├──grainoil-dfs --文件
|
├──grainoil-tool --工具
|  |
|  ├──grainoil-monitor --监控中心
|
├──grainoil-ant --前端 使用ant design框架

```



启动顺序：
- eureka
- config
- gateway
- system
- auth
- gen 可选
- dfs 可选


前端使用ant-design-vue 
monitor使用springadmin完成,目前只是最简单的用法
文档：
   swagger:
   http://127.0.0.1:9527/doc.html
   
后端接口统一返回ResponseResult
   
   
参考：若依
官方文档：https://doc.ruoyi.vip/ruoyi-cloud/
本项目对应的文档：http://doc.rycloud.zmrit.com/#/
