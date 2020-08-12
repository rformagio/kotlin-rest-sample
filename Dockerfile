FROM openjdk:12-alpine3.9 AS builder

USER root

ARG artifactory_contextUrl
ARG artifactory_user
ARG artifactory_password

ENV ORG_GRADLE_PROJECT_artifactory_user=$artifactory_user
ENV ORG_GRADLE_PROJECT_artifactory_password=$artifactory_password
ENV ORG_GRADLE_PROJECT_artifactory_contextUrl=$artifactory_contextUrl

ENV APP_DIR /app
WORKDIR $APP_DIR

RUN apk add --no-cache curl

COPY gradlew gradle.properties build.gradle.kts ./
COPY gradle gradle
RUN ./gradlew --no-daemon dependencies

COPY . .
RUN ./gradlew --no-daemon bootJar -x test

# -----------------------------------------------------------------------------

FROM openjdk:12-alpine3.9

RUN apk add --no-cache tini

WORKDIR /app

COPY newrelic/newrelic.jar /app/
COPY newrelic/newrelic.yml /app/
COPY init.sh /app/
COPY --from=builder /app/build/libs/ /app/

EXPOSE 8080

ENTRYPOINT ["tini", "-s", "--", "sh", "init.sh"]
