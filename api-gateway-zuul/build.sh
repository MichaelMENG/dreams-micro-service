#!/usr/bin/env bash

mvn clean package -DskipTests -U

docker build -t hub.dreams.com/dreams-micro-service/api-gateway-zuul:1.1-SNAPSHOT .

docker push hub.dreams.com/dreams-micro-service/api-gateway-zuul:1.1-SNAPSHOT
