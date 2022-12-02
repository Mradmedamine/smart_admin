FROM lwieske/java-8:jre-8u202-slim

COPY /target/smart_admin-1.0.0.jar .

EXPOSE 8080
ENV TZ Europe/Brussels

CMD java -Dserver.port=$PORT -Dspring.profiles.active=heroku $JAVA_OPTS -jar service/smart_admin-1.0.0.jar