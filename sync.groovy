#!/usr/bin/env groovy

def lines = new File("list.txt").readLines()
for(image in lines) {
    if(image.length() <=1) {
        continue
    }
    def image = image.replace("k8s.gcr.io","hellojukay")
    "docker pull ${image} ".execute()
    "docker tag ${image} ${tag}".execute()
    "docker push ${image} ".execute()
}