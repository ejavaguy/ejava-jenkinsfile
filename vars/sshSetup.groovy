!/usr/bin/env groovy

def call() {
    container('maven') {
	withCredentials([sshUserPrivateKey(credentialsId: 'webdev-publish-key',
							   keyFileVariable: 'SSH_KEYS',
							   passphraseVariable: 'SSH_PASS',
							   usernameVariable: 'SSH_USER')]) {
	    sshagent( credentials:['webdev-publish-key'])   {
		sh 'mkdir -p ~/.ssh'
		sh 'ssh-keyscan -t rsa webdev.jhuep.com >> ~/.ssh/known_hosts'
		sh 'chmod 640 ~/.ssh/known_hosts'
	    }
	}
    }
}
