pipeline {
  agent {
    docker {
      image 'maven:3.5.2-jdk-8'
      args '-v C:\\Users\\Moon\\.m2'
    }
    
  }
  stages {
    stage('Initialize') {
      steps {
        sh '''echo PATH=%PATH%

echo M2_HOME=%M2_HOME
mvn clean'''
      }
    }
    stage('Build') {
      steps {
        sh 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }
    stage('Report') {
      steps {
        junit 'target/surefire-reports/**/*.xml'
      }
    }
    stage('Archive') {
      steps {
        archiveArtifacts 'target/*.jar,target/*.hpi'
      }
    }
  }
}