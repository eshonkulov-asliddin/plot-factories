#!/usr/bin/env groovy
pipeline {

    def tomcatWeb = "C:\\tomcat\\apache-tomcat-9.0.82\\webapps"
    
    agent any

    tools {
      maven '3.9.5'
    }

    stages {
        stage('Scan') {
            steps {
                withSonarQubeEnv(installationName: 'sonar') {
                    bat 'mvn clean verify sonar:sonar'
                }
            }
        }

        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Deploy to Tomcat') {
            steps {
                bat "copy target\\filter-1.0-SNAPSHOT.war \"${tomcatWeb}\\filter-1.0-SNAPSHOT.war\""
            }
        }
    
    }
}
