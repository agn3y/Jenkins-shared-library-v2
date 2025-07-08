def call() {
    echo "building jar"
    sh "mvn clean package"
}

