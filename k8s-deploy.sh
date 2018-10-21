#!/usr/bin/env bash

IMAGE=`cat IMAGE_NAME`

DEPLOYMENT=$1
MODULE=$2

echo "update image to: ${IMAGE}"

kubectl set image deployments/${DEPLOYMENT} ${MODULE}=${IMAGE}
