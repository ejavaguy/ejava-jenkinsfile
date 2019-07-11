#!/usr/bin/env groovy

def equals(branch, Closure doTrue, Closure doFalse) {
  if (env.BRANCH_NAME == "${branch}") {
    doTrue()
  } else {
    doFalse()
  }
}

def matches(branch, Closure doTrue, Closure doFalse) {
  if (env.BRANCH_NAME =~ /${branch}/) {
    doTrue()
  } else {
    doFalse()
  }
}
