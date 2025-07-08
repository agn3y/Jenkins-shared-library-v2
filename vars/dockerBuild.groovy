#!/usr/bin/env groovy
import com.example.Docker

def call(String imageName) {
    def docker = new Docker(this)
    docker.buildDockerImage(imageName)
}
