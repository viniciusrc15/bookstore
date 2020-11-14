FROM maven:3.6.1-jdk-8-alpine AS MAVEN_BUILD
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn package -DskipTests

FROM openjdk:8-jre-alpine

COPY --from=MAVEN_BUILD /build/target/api-0.0.1-SNAPSHOT.jar /api.jar

ENTRYPOINT ["java","-jar","/api.jar"]