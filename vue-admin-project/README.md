# vue-admin-project

##### 项目简介

1. 此项目用于练手vue2+springboot
2. 前端使用了vue2的[vue-admin-template](https://github.com/PanJiaChen/vue-admin-template)模板进行改造
3. 后端中使用了springboot
4. 数据库为MySQL
5. 缓存使用Redis

##### 项目安装

```
# clone the project
git clone git@github.com:Kyrieyu11/PracticeProjects.git

# enter the project directory
cd vue-admin-project

# Maven package
cd BackEnd
mvn clean
mvn package

# Start BackEndServer
chmod 744 ./BackEnd.sh
./BackEnd.sh start

# Start FontEndServer
./FontEnd.sh start
```

##### 项目默认配置

1. 前端端口默认在localhost:9528
2. 后端端口默认在localhost:8080

##### 项目目录简介

1. BackEnd：放置后端代码
2. logs：前后端服务器启动后，日志文件会放在这里
3. vue-admin-template：前端代码，具体内容可以参照 [vue-admin-template](https://github.com/PanJiaChen/vue-admin-template)
4. BackEnd.sh：后端服务器启动脚本
5. FontEnd.sh：前端服务器启动脚本
