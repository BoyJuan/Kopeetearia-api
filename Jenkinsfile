pipeline{
	agent any
	
	stages{
	    tools {
        	maven 'Maven 3.8.3'
        	jdk 'jdk11'
    	}
		stage('Unit Test'){
			steps{
				bat "mvn clean compile"
			}		
		}
	}
}
