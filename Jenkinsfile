pipeline{
	agent any
	
	stages{
		stage('Unit Test'){
			steps{
				bat "mvn test"
			}		
		}
		stage('SonarQube Analysis'){
			steps{
				echo "Sonar Scanner"
				
			}		
		}
		stage('Build'){
			steps{
				bat "mvn clean compile"
			}		
		}
		stage('Deploy'){
			steps{
				echo "Di nako :("
			}		
		}
	}
