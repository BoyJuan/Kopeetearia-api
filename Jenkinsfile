pipeline{
	agent any
	
	stages{
		stage('Unit Test'){
			steps{
				bat "mvn clean test"
			}		
		}
  		stage('SonarQube analysis') {
    		def scannerHome = tool 'SonarQube Scanner';
    		withSonarQubeEnv('SonarQube'){ 
			sh "${scannerHome}/bin/sonar-scanner"
    		}
 		}
		stage('Build'){
			steps{
				bat "mvn clean compile"
			}		
		}
	}
}
