FROM hub.dreams.com/base-resources/openjdk:8-jre-alpine

MAINTAINER dreamstep36 dreamstep36@163.com

COPY target/*.jar user-edge-service.jar

EXPOSE 8001

ENTRYPOINT ["java", "-jar", "/user-edge-service.jar"]