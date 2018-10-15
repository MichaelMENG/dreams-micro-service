#!/usr/bin/env bash

mvn clean package -DskipTests -U

docker build -t hub.dreams.com/dreams-micro-service/course-dubbo-service:1.0-SNAPSHOT .

docker push hub.dreams.com/dreams-micro-service/course-dubbo-service:1.0-SNAPSHOT
