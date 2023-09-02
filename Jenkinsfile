pipeline {

    agent any

    parameters {
        choice(name: 'IS_SELENOID', choices: [true, false], description: 'use selenoid for tests')
        choice(name: 'IS_VIDEO', choices: [true, false], description: 'use video recording on selenoid')
    }

    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '14', numToKeepStr: '5')
    }

    stages {

        stage('GIT') {
          steps {
            git branch: 'main', url: 'https://github.com/andreevmo/automation_test.git'
          }
        }

        stage('RUN TESTS') {
          steps {
            sh "chmod +x gradlew"
            sh "./gradlew build"
          }
        }

    }

    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]
        }
    }

}