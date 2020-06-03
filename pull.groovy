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
def lines = new File("v1.18.3_list.txt").readLines()
for(image in lines) {
    if(image.length() <=1) {
        continue
    }
    image = image.trim()
    def tag = image.replace("k8s.gcr.io","hellojukay").trim()
    println(tag)
    sh("docker pull ${tag}")
    sh("docker tag ${tag} ${image}")
    sh("docker rmi ${tag}")
}
