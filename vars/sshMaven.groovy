#!/usr/bin/env groovy

def call(String credentialsId, Closure body) {
	  configFileProvider([configFile(fileId: env.MAVEN_SETTINGS_ID, variable: 'MAVEN_SETTINGS_PATH')]) {
			sshagent( credentials:[credentialsId])   {
				body()
			}
	  }
}
