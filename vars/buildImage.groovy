def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'Dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t agneypatel/test-repoo:1.7 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push agneypatel/test-repoo:1.7'
    }
}

