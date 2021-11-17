# dev-challenge
this is a project using Java, Springboot to create an API only with the create and read funtions of the CRUD. Please note that this project was done under Windows OS, and the 8 JDK version.

First you have to install the dependencies from maven, you can do it using the command:

mvn clean install -DskipTests=true

Start the docker-compose to provide de postgres database of the project, use the command:

docker-compose up

Now you can start the application, (you should use another terminal session to do it) use the command:

.\mvnw.cmd spring-boot:run

To test the services of the application you must use a client as a postman to make the requests to this project,
use the localhost/8080/api/person end point
