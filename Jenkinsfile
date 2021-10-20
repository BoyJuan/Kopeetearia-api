pipeline{
	agent any
	
	stages{
		stage('Unit Test'){
			steps{
				git ''
				bat 'mvn test'
			}		
		}
		stage('Sonar'){
			steps{
				echo 'Sonar Scanner'
				def scannerHome = tool 'SonarQube Scanner'
				withSonarQubeEnv('SonarQube Server') {
					bat "${scannerHome}/bin/sonar-scanner"
				}
			}		
		}
		stage('Build'){
			steps{
				git 'https://github.com/BoyJuan/Kopeetearia-api.git'
				bat 'mvn clean compile'
			}		
		}
		stage('Deploy'){
			steps{
				echo 'Di nako :('
			}		
		}
	}
}