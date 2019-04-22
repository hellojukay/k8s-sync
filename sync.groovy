#!/usr/bin/env groovy

def sh(String cmd) {
    println("cmd: $cmd")
    def sout = new StringBuilder(), serr = new StringBuilder()
    def proc = cmd.execute()
    proc.consumeProcessOutput(sout, serr)
    proc.waitForOrKill(100000000)
    println "$sout"
    println "$serr"
}
def lines = new File("v1.14.0_list.txt").readLines()
for(image in lines) {
    if(image.length() <=1) {
        continue
    }
    image = image.trim()
    def tag = image.replace("k8s.gcr.io","hellojukay").trim()
    sh("docker pull ${image}")
    sh("docker tag ${image} ${tag}")
    sh("docker push ${tag}")
}
