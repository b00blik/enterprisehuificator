FROM adoptopenjdk/openjdk11
RUN addgroup spring &&  \
    adduser --ingroup spring spring
USER spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]