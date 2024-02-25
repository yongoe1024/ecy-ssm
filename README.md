ecy-ssm管理系统

## 介绍
代码和功能都极简的管理系统，配有自动生成器，用户管理 ，角色管理，菜单管理，系统日志，数据字典，部门，职位，站内信等功能

## 技术栈 
* 框架：java11，springmvc，spring5，vue2+vuex+vue-router，mysql8  
* 技术：mybatis-plus，lombok，mapstruct，jwt，easypoi
* 使用mapstruct，对reqVo-resVo-entity等进行互转  

## 目录结构
├─ecy-common    公共工具类  
├─ecy-generator 代码生成模块  
├─ecy-system    系统模块  
├─ecy-server    启动模块，新业务模块放在这里  
├─ecy-ui        vue2项目

## 安装教程
1. ecy-server中的config.properties为配置文件，修改数据库  
2. 后端的端口由tomcat设置：在idea运行配置中选择tomcat8.5，然后修改端口为8081，勾选`Tomcat服务器设置-部署Tomcat实例中配置的应用程序`，启动即可  
3. 如果要进行文件上传下载，包括修改头像，需要找到tomcat安装目录，进入conf/server.xml  
在`<Host>`标签下添加`<Context docBase="文件存储路径/Users/yongoe/code/ecy-file" path="/file"/>`，其中/file的ecy为后端访问路径，一般是war包的名字  
4. 修改后端配置变量，在WEB-INF/web.xml中：  
```xml     <context-param>
    <context-param>
        <param-name>ecy.file-save-path</param-name>
        <param-value>/Users/yongoe/code/ecy-file</param-value>
    </context-param> 
```
#### 前端
ecy-ui 中的`README.md`为前端文档
1. 安装`nodejs16`（15也可以，高版本没试过）
2. 配置npm镜像源`npm config set registry https://registry.npm.taobao.org`
3. 进入`/ecy-ui`目录，执行`npm install`，安装依赖
4. .env.dev和.env.prod为环境变量，修改后端地址:其中/ecy为后端访问路径
5. 执行`npm run serve`，启动vue项目
6. 账号admin，密码111111
7. vue.config中`publicPath: '/'`，与上边同步，后端访问路径

#### 文件上传下载目录
上传文件，用户头像等，存储在`ecy-file`文件夹

##未完成
1. 序列号与反序列化，统一datatime格式
2. 序列化时将Long转为String