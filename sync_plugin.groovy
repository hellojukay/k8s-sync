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
def tag(String image , String tag) {
  sh("docker pull ${image}")
  sh("docker tag ${image} ${tag}")
  sh("docker push ${tag}")
}

def sync(String file){
  def lines = new File(file).readLines()
  for(image in lines) {
      if(image.length() <=1) {
          continue
      }
      def images = image.split("=>")
      tag(images[0].trim(), images[1].trim())
  }
}

def sync_list(String []files) {
  for(String file in files) {
    sync(file)
  }
}

sync_list (
    "quay.io_list.txt",
    "k8s.gcr.io_list.txt"
    )
