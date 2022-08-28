chmod +x ./mvnw
./mvnw clean package -DskipTests
cp target/demoday-1.0.2.RELEASE.war ./src/main/docker
