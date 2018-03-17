# BreadNBucks
This project is intended to provide intelligent tips such to buy or sell the stock; based on the users selected sector.

##How to build :
Build as a maven project.

##Pre-Requisities : 
Oracle Database should be set up. Please run the db scripts from here to create the database structure & then run the static_init to populate values in database for first time use.
* Database_Model
* Static_Data

##Administration:
	### Set up Jenkins
	Download latest jenkins.war from here (https://updates.jenkins-ci.org/latest/jenkins.war)
	Make sure that Java is set up in tohe system home 
	start jenkins by java -jar <path to the jenkins war>\jenkins.war --httpPort=9090
	
	### Set up Sonar
	Download latest from here https://www.sonarqube.org/downloads/
	Unzip & run the sonar.bat from the bin.
	Add below lines to maven settings in your <Home Dir>/.m2/settings.xml
  
	<profiles>
	<profile>
            <id>sonar</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <!-- Example for MySQL-->
                <sonar.jdbc.url>
                  jdbc:mysql://localhost:3306/sonar?useUnicode=true&amp;characterEncoding=utf8
                </sonar.jdbc.url>
                <sonar.jdbc.username>sonar</sonar.jdbc.username>
                <sonar.jdbc.password>sonar</sonar.jdbc.password>
 
                <!-- Optional URL to server. Default value is http://localhost:9000 -->
                <sonar.host.url>
                  http://localhost:9000
                </sonar.host.url>
            </properties>
        </profile>
        </profiles>
