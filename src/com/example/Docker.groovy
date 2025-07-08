#!/usr/bin/env groovy
package com.example

class Docker implements Serializable {

    def script
    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "Building the docker image"
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(
                credentialsId: 'Dockerhub',
                passwordVariable: 'PASS',
                usernameVariable: 'USER'
        )]) {
            script.sh "echo \$PASS | docker login -u \$USER --password-stdin"
        }
    }

    def dockerPush(String imageName) {
        script.sh "docker push $imageName"
    }
}
