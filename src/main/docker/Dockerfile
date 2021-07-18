# 该镜像需要依赖的基础镜像
FROM java:8
VOLUME /tmp
# 将当前目录下的jar包复制到docker容器的/目录下
ADD springdemo-0.0.1-SNAPSHOT.jar springdemo.jar

# 运行过程中创建一个springdemo.jar文件
RUN sh -c 'touch /springdemo.jar'

# 声明服务运行在8080端口
EXPOSE 10009

ENV JAVA_OPTS="-Dfile.encoding=UTF-8 -server -Xms256m -Xmx512m "

# 指定docker容器启动时运行jar包
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /springdemo.jar" ]

# 指定维护者的名字
MAINTAINER fengzijk guozhifengvip@gmail.com
