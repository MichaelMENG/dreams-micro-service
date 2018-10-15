#!/usr/bin/env bash

docker build -t hub.dreams.com/base-resources/python:3.6.3-thrift -f Dockerfile.base .

docker push hub.dreams.com/base-resources/python:3.6.3-thrift

