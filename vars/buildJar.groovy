#!/usr/bin/rnv groovy
def call () {
    echo "Bulding the application"
    sh "mvn package"
}