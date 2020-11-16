# k8s-sync
![badage](https://travis-ci.org/hellojukay/k8s-sync.svg?branch=master)

自动同步 k8s 官方镜像到 docker hub .
# 获取 kubeadm 镜像信息
```shell
kubeadm config images list
```
# 使用

```shell
perl pull.pl v1.19.4_list.txt
```
