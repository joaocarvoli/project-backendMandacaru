FROM adoptopenjdk:11-jdk
WORKDIR app
COPY . .
RUN chmod +x ./mvnw && ./mvnw clean package -DskipTests
WORKDIR target
ENTRYPOINT ["java", "-jar", "demoday-0.0.1-SNAPSHOT.war"]
