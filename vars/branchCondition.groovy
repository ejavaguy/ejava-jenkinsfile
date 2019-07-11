#!/usr/bin/env groovy

def call(script, Closure doTrue, Closure doFalse) {
  if (branch 'jenkins-master') {
    doTrue()
  } else {
    doFalse()
  }
}
