FROM hub.dreams.com/base-resources/python:3.6.3-thrift

MAINTAINER dreamstep36 dreamstep36@163.com

ENV PYTHONPATH /

COPY message /message

EXPOSE 9090

ENTRYPOINT ["python", "/message/message_service.py"]
