#!/usr/bin/env groovy
import com.example.Docker
def call() {
    def docker = new Docker(this)
    docker.dockerLogin()
}

