node {

    try {
        stage('Start') {
            // slackSend (channel: '#jenkins', color: '#FFFF00', message: "STARTED: Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]' (${env.BUILD_URL})")
        }

        stage('git sslVerify off') {
            sh(script: "git config --global http.sslVerify false || true")
        }

        stage('git source Pull') {
            checkout scm
        }

        stage("SpringBoot build") {
            sh(script: "chmod 775 .")
            sh(script: "./gradlew clean build")
        }

        stage("Nexus publish") {
            sh(script: "chmod 775 .")
            sh(script: "./gradlew publish")
        }

    } catch(e) {
        print(e)
    }

}