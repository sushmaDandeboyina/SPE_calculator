FROM openjdk:11

WORKDIR /app

COPY target/ScientificCalculator-1.0-SNAPSHOT.jar calculator.jar

CMD ["java", "-jar", "calculator.jar"]
