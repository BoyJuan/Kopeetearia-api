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
				bat "mvn clean package"
			}		
		}
		stage('Deploy'){
			environment {
        		tomcatWeb = 'C:\\Users\\john.alex.ocay\\Documents\\Boot Camp\\Dev Ops\\DevOps Assessment\\Tomcat\\apache-tomcat-9.0.54-windows-x64\\apache-tomcat-9.0.54\\webapps'
    		}
			steps{
				bat "copy target\\ws.war \"${tomcatWeb}\\ws.war\""
			}		
		}
	}
}
