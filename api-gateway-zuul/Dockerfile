FROM hub.dreams.com/base-resources/openjdk:8-jre-alpine

MAINTAINER dreamstep36 dreamstep36@163.com

COPY target/*.jar api-gateway-zuul.jar

EXPOSE 9001

ENTRYPOINT ["java", "-jar", "/api-gateway-zuul.jar"]
