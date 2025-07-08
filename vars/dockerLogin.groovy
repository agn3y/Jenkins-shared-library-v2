#!/usr/bin/env groovy
import com.example.Docker

def call() {
    def imageName = env.IMAGE_NAME ?: 'agneypatel/test-repoo:latest'
    def docker = new Docker(this)
    docker.dockerLogin()
}

