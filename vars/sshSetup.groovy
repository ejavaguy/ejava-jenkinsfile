#!/usr/bin/env groovy

def call(String host) {
	if (null!=host && !host.isEmpty()) {
		sh '[ -d ~/.ssh ] || mkdir ~/.ssh && chmod 0700 ~/.ssh'
		sh "ssh-keyscan -t rsa,dsa ${host} >> ~/.ssh/known_hosts"
	}
}
