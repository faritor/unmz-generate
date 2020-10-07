# unmz-generate

批量生成基础结构

项目代码来源已经找不到了，经过自己的修改更适合开发，特分享给大家，希望可以帮到大家。

使用方式:

1.找到resources目录下的template文件夹,该目录下是程序生成时使用的文件模板.

2.可用TestDemo.java文件中的测试方法体验

3.在使用之前请修改静态方法块中的配置信息

默认生成的是Mybatis Plus使用的代码，可根据自己业务进行调整。





### DataModel介绍

| 参数名            | 是否必填 | 描述                                                         |
| ----------------- | -------- | ------------------------------------------------------------ |
| basePackage       | 是       | base包的路径                                                 |
| businessPackage   | 是       | 业务包的路径                                                 |
| category          | 否       | 业务包下是否有子路径，若有则填，若无，则为空                 |
| url               | 是       | mysql数据库连接地址                                          |
| username          | 是       | mysql用户名                                                  |
| password          | 是       | mysql密码                                                    |
| databaseName      | 是       | mysql数据库                                                  |
| sourceRootPackage | 否       | 默认“out”                                                    |
| projectName       | 否       | 类文件描述                                                   |
| funcDesc          | 否       | 类文件描述                                                   |
| ignoreHead        | 否       | 是否忽略表明第一个下划线左边的内容 如"t_table" true则忽略"t_"部分,生成的相关代码都是Table开头, false则不忽略,生成的相关代码都是TTable，默认false |

