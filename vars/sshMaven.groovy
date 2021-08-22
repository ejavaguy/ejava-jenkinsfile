#!/usr/bin/env groovy

def call(String credentialsId, Closure body) {
	  configFileProvider([configFile(fileId: env.MAVEN_SETTINGS_ID, variable: 'MAVEN_SETTINGS_PATH')]) {
			withCredentials([sshUserPrivateKey(credentialsId: credentialsId,
									   keyFileVariable: 'SSH_KEYS',
									   passphraseVariable: 'SSH_PASS',
									   usernameVariable: 'SSH_USER')]) {
				sshagent( credentials:[credentialsId])   {
						body()
				}
			}
	  }
}
