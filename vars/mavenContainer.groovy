#!/usr/bin/env groovy

def call(Closure body) {
    container('maven') {
      configFileProvider([configFile(fileId: env.SETTINGS_XML,
			  variable: 'MAVEN_SETTINGS_XML')]) {
	withCredentials([sshUserPrivateKey(credentialsId: 'webdev-publish-key',
							   keyFileVariable: 'SSH_KEYS',
							   passphraseVariable: 'SSH_PASS',
							   usernameVariable: 'SSH_USER')]) {
	    sshagent( credentials:['webdev-publish-key'])   {
                body()
	    }
	}
      }
    }
}
