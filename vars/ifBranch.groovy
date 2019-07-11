#!/usr/bin/env groovy

def call(branch, Closure doTrue, Closure doFalse) {
  if (env.BRANCH_NAME =~ /${branch}/) {
    doTrue()
  } else {
    doFalse()
  }
}
