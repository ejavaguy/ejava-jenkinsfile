#!/usr/bin/env groovy

def call(script, branch, Closure doTrue, Closure doFalse) {
  if (script.env.BRANCH_NAME == "${branch}") {
    doTrue(script)
  } else {
    doFalse(script)
  }
}
