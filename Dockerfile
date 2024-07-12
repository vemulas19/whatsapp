# Use a base image with Java and Maven
FROM maven:3.8.4-openjdk-11

# Install Git
RUN apt-get update && apt-get install -y git

# Install Copybara
RUN curl -L https://github.com/google/copybara/releases/download/0.9/copybara-0.9.0-Linux-x86_64 -o /usr/local/bin/copybara && chmod +x /usr/local/bin/copybara

# Set the working directory
WORKDIR /app

# Copy the project files
COPY . /app

# Build the Maven project
RUN mvn clean install

# Entry point for the container
ENTRYPOINT ["sh", "-c", "while :; do sleep 2073600; done"]
