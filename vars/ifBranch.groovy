#!/usr/bin/env groovy

def equals(branch, Closure doTrue, Closure doFalse) {
  if (script.env.BRANCH_NAME == "${branch}") {
    doTrue(script)
  } else {
    doFalse(script)
  }
}

def matches(branch, Closure doTrue, Closure doFalse) {
  if (script.env.BRANCH_NAME =~ /${branch}/) {
    doTrue(script)
  } else {
    doFalse(script)
  }
}
