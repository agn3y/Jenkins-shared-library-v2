def call() {
    def imageName = this.env.IMAGE_NAME ?: 'agneypatel/test-repoo:latest'
    return new Docker(this).buildDockerImage(imageName)
}

