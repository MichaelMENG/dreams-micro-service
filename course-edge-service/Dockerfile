FROM hub.dreams.com/base-resources/openjdk:8-jre-alpine

MAINTAINER dreamstep36 dreamstep36@163.com

COPY target/*.jar course-edge-service.jar

EXPOSE 9001

ENTRYPOINT ["java", "-jar", "/course-edge-service.jar"]