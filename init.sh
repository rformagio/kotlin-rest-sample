#!/usr/bin/env bash

set -e

ENVIRONMENT_NAME="${SPRING_PROFILES_ACTIVE:-"development"}"
JVM_OPS="${JVM_OPS:-""}"
NEWRELIC_APP_NAME="${NEWRELIC_APP_NAME:-"carteiritas"}"
APPLICATION_PORT="${PORT:-"8000"}"
echo "ENVIRONMENT_NAME: ${ENVIRONMENT_NAME}"

COMMAND=${1:-"web"}
echo $COMMAND

case "$COMMAND" in
  migrate|web)
    # NOTE: NewRelic won't work unless -javaagent is the first argument
    exec java ${JVM_OPS} -Djava.security.egd=file:/dev/./urandom \
      -javaagent:/app/newrelic.jar \
      -Duser.Timezone=America/Sao_Paulo \
      -Dnewrelic.config.license_key=${NEWRELIC_TOKEN} \
      -Dnewrelic.config.app_name=${NEWRELIC_APP_NAME} \
      -Dnewrelic.config.distributed_tracing.enabled=true \
      -Dspring.profiles.active=${ENVIRONMENT_NAME} \
      -Dspring.datasource.url=${DATABASE_URL} \
      -Dserver.port=$APPLICATION_PORT \
      -jar /app/carteiritas-*.jar \
      $COMMAND
    ;;
  *)
    exec sh -c "$*"
    ;;
esac
