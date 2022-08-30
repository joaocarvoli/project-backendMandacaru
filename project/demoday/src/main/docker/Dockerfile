FROM adoptopenjdk:11-jre-hotspot
WORKDIR app
COPY demoday-1.0.2.RELEASE.war ./demoday.war
ENTRYPOINT ["java", "-jar", "demoday.war"]
