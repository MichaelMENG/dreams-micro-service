FROM hub.dreams.com/base-resources/openjdk:8-jre-alpine

MAINTAINER dreamstep36 dreamstep36@163.com

ADD target/*.jar user-thrift-service.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "/user-thrift-service.jar"]