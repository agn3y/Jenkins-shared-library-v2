#!/usr/bin/env groovy

def call() {
    echo "🔧 Starting Docker image build process..."
    def imageName = env.IMAGE_NAME ?: 'agneypatel/test-repoo:latest'
    echo "📦 Image name to build and push: ${imageName}"
    withCredentials([usernamePassword(credentialsId: 'Dockerhub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        echo "🐳 Building Docker image..."
        sh "docker build -t ${imageName} ."
        echo "🔐 Logging in to DockerHub..."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        echo "🚀 Pushing image to DockerHub..."
        sh "docker push ${imageName}"
        echo "✅ Docker image pushed successfully: ${imageName}"
    }
}

