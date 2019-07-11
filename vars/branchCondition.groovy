#!/usr/bin/env groovy

def call(Closure doTrue, Closure doFalse) {
  if (branch 'jenkins-master') {
    doTrue()
  } else {
    doFalse()
  }
}
