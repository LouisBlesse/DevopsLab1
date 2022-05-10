pipeline {
    agent any
    tools { 
        maven 'Maven 3.8.1' 
        jdk 'openjdk-11' 
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
                sh "mvn clean install"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "mvn clean test"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
