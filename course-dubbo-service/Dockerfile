FROM hub.dreams.com/base-resources/openjdk:8-jre-alpine

MAINTAINER dreamstep36 dreamstep36@163.com

COPY target/*.jar course-dubbo-service.jar

ARG mysqlAddress
ENV mysql.address=mysqlAddress

ARG zookeeperAddress
ENV zookeeper.address=zookeeperAddress

EXPOSE 9000

ENTRYPOINT ["java", "-jar", "/course-dubbo-service.jar"]