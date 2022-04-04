FROM maven:3.8.1-jdk-11



COPY src /home/CHTest/src

COPY pom.xml /home/CHTest

COPY testng.xml /home/CHTest

COPY FailedScreenshots /home/CHTest/FailedScreenshots

COPY src/test/resources/APIResponseSchema.json /home/CHTest/src/test/resources/APIResponseSchema.json

COPY src/test/resources/Configuration.properties /home/CHTest/src/test/resources/Configuration.properties


RUN mvn -f /home/CHTest/pom.xml clean test -DskipTests=true -Dbrowser="remoteChrome" -e