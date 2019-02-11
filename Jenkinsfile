node {
  stage('SCM') {
    git 'https://github.com/joonvena/SpringBootTuntikirjaus.git'
  }
  stage('SonarQube analysis') {
    withSonarQubeEnv('mySonarQube') {
      // requires SonarQube Scanner for Maven 3.2+
      sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.2:sonar'
    }
  }
}
