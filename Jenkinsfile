pipeline{
	agent any
	
	stages{
		stage('Unit Test'){
			steps{
				git ''
				bat 'mvn test'
			}		
		}
		stage('SonarQube Analysis'){
			steps{
				echo 'Sonar Scanner'
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