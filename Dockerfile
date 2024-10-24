FROM amazoncorretto:17-alpine-jdk
LABEL maintainer="Kaouther Ben Sassi bensassi.kaouther@gmail.com"
COPY target/financeBFF-0.0.1-SNAPSHOT.jar financeBFF-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "financeBFF-0.0.1-SNAPSHOT.jar"]