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
            bat "${scannerHome}/bin/sonar-scanner"
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
