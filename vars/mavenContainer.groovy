#!/usr/bin/env groovy

def call(Closure body) {
    container('maven') {
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
