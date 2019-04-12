#!/usr/bin/env bash

docker pull k8s.gcr.io/kube-apiserver:v1.13.0
docker tag k8s.gcr.io/kube-apiserver:v1.13.0 hellojukay/kube-apiserver:v1.13.0
docker push hellojukay/kube-apiserver:v1.13.0