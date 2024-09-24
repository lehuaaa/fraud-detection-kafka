FROM openjdk:17-jdk-slim

# Work directory
WORKDIR /app

# Copy jar file inside work directory
COPY target/transaction-api-0.0.1.jar app.jar

#Expose port 8080
EXPOSE 8080

# Execute application
ENTRYPOINT ["java", "-jar", "app.jar"]