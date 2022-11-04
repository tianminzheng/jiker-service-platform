
这是Dubbo案例项目的完整演示代码，包括如下代码工程：

·jiker-infrastructure

包含案例项目用到的一些基础工具类，例如异常处理、分布式主键等功能

·jiker-integration-service

包含案例项目的集成服务定义和实现组件，用于完成与各个供应商服务之间的集成

·jiker-middle-service

包含案例项目的中台服务定义和实现组件，用于完成与集成服务之间的交互和集成

·jiker-frontend-service

包含案例项目的前台服务定义和实现组件，用于完成与中台服务之间的交互和集成

·provider-service1和provider-service2

包含案例项目的两个供应商服务，面向集成服务提供基础数据

·custom-service1

包含案例项目的一个第三方外部服务，完成与前台服务已经中台服务之间的集成

