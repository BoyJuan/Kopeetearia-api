pipeline{
	agent any
	
	stages{
		stage('Unit Test'){
			steps{
				bat "mvn clean test"
			}		
		}
		stage('Sonarqube') {
    		environment {
        		scannerHome = tool 'SonarQubeScanner'
    		}
    		steps {
        		withSonarQubeEnv('sonarqube') {
            		sh "${scannerHome}/bin/sonar-scanner"
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
