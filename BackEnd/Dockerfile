FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/CreditCardBackend.war CreditCardBackend.war
ENTRYPOINT ["java","-jar","/CreditCardBackend.war"]