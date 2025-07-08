#!/usr/bin/env groovy
import com.example.Docker

import com.example.Docker

def call(String imageName = null) {
    if (imageName == null) {
        imageName = this.env.IMAGE_NAME ?: 'agneypatel/test-repoo:latest'
    }
    def docker = new Docker(this)
    docker.dockerPush(imageName)
}
}
