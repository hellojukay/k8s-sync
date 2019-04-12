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
def lines = new File("list.txt").readLines()
for(image in lines) {
    if(image.length() <=1) {
        continue
    }
    image = image.trim()
    sh("docker pull ${image}")
    def tag = image.replace("hellojukay","k8s.gcr.io").trim()
    sh("docker tag ${image} ${tag}")
}
