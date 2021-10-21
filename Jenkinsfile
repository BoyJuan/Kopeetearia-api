pipeline{
	agent any
	
	stages{
		stage('Unit Test'){
			steps{
				bat "mvn clean test"
			}		
		}
stage('Sonarqube Analysis') {
    environment {
        scannerHome = tool 'SonarQube Scanner'
    }
    steps {
        withSonarQubeEnv('sonarqube') {
            sh "${scannerHome}/bin/sonar-scanner"
        }
        timeout(time: 10, unit: 'MINUTES') {
            waitForQualityGate abortPipeline: true
        }
    }
}
		stage('Build'){
			steps{
				bat "mvn clean compile"
			}		
		}
	}
}
