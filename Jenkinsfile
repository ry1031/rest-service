pipeline {
  agent any
  stages {
    stage('Initialize') {
      steps {
        bat 'echo %JAVA_HOME%; echo %PATH%'
      }
    }
    stage('Build') {
      steps {
        bat 'mvn -Dmaven.test.failure.ignore=true install'
      }
    }
    stage('Report') {
      steps {
        junit 'target/surefire-reports/**/*.xml'
        archiveArtifacts 'target/*.jar,target/*.hpi'
      }
    }
  }
}