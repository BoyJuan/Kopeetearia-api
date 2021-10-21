pipeline{
	agent any
	
	stages{
		stage('Unit Test'){
			steps{
				bat "mvn clean test"
			}		
		}
		stage('Build'){
			steps{
				bat "mvn clean compile"
			}		
		}
	}
}
