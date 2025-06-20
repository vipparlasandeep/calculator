pipeline {
    agent any

    stages {
        stage('build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Publish Coverage Report') {
        steps {
            jacoco execPattern: '**/target/jacoco.exec'
        }
        }

        stage('test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
    always {
      junit '**/target/surefire-reports/*.xml'
    }
  }
}
