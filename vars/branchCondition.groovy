#!/usr/bin/env groovy

def call(Closure doTrue, Closure doFalse) {
  branch 'jenkins-master' {
    doTrue()
  } 
}
