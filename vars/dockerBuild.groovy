#!/usr/bin/env groovy
import com.example.Docker

def call(String imageName) {
    imageName = imageName ?: env.IMAGE_NAME ?: 'agneypatel/test-repoo:latest'
    return new Docker(this).buildDockerImage(imageName)
}

