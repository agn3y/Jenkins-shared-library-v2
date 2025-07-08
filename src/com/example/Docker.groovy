#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script
    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building the docker image"
        script.withCredentials([script.usernamePassword(
            credentialsId: 'Dockerhub', 
            passwordVariable: 'PASS', 
            usernameVariable: 'USER'
        )]) {
            script.sh "docker build -t $imageName ."
            script.sh "echo \$PASS | docker login -u \$USER --password-stdin"
            script.sh "docker push $imageName"
        }
    }
}

