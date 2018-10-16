#!/usr/bin/env bash

docker build -t hub.dreams.com/dreams-micro-service/message-thrift-python-service:1.1-SNAPSHOT .

docker push hub.dreams.com/dreams-micro-service/message-thrift-python-service:1.1-SNAPSHOT
