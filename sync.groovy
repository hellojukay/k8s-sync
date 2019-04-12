#!/usr/bin/env groovy

def sh(String cmd) {
    println("cmd: $cmd")
    def sout = new StringBuilder(), serr = new StringBuilder()
    def proc = cmd.execute()
    proc.consumeProcessOutput(sout, serr)
    proc.waitForOrKill(1000)
    println "out:$sout"
    println "err: $serr"
}
def lines = new File("list.txt").readLines()
for(image in lines) {
    if(image.length() <=1) {
        continue
    }
    def tag = image.replace("k8s.gcr.io","hellojukay")
    sh("docker pull ${image}")
    sh("docker tag ${image} ${tag}")
    sh("docker push ${tag}")
}
