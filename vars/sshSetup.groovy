#!/usr/bin/env groovy

def call(String host) {
	if (null!=host && !host.isEmpty()) {
		sh 'mkdir -p ~/.ssh'
		sh "ssh-keyscan -t rsa ${host} >> ~/.ssh/known_hosts"
		sh 'chmod 0700 ~/.ssh && chmod 640 ~/.ssh/known_hosts'
	}
}
