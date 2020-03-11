## Credit Card Management
1. Frontend : ReactJs
2. Backend  : SpringBoot with H2 In-memory Database

### BackEnd
#### As Springboot App:
Steps to run the application :
1. `cd Backend`
2. `mvn clean package`
3. `mvn spring-boot:run`

The application is running at `10090` port number configured in `application.resources`. </br>
At the moment 2 REST Endpoints are exposed at the below url :

1. GET : /card/getall
2. POST : /card/add

#### As Executable war:
We have made executable war so one can also use below commands to run the application:
1. `cd Backend`
2. `mvn clean package`
3. `java -jar target/CreditCardBackend.war`

#### As Docker Image:
To run this application as docker image we have created a simple Dockerfile:
1. `cd Backend`
2. `mvn clean package`
3. `docker build -t backend/springboot .`
4. `docker build -it -p 10090:10090 backend/springboot:latest`

### FrontEnd
Steps to run the application :
1. `cd FrontEnd`
2. `npm install`
3. `npm start`

The application is running at `3000` port number and is consuming the Backend Rest Endpoints.</br>
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

#### FrontEnd As Docker Image:
To run this application as docker image we have created a simple Dockerfile:
1. `cd FrontEnd`
3. `docker build -t frontend/reactjs .`
4. `docker build -it -p 3000:3000 frontend/reactjs:latest`

Note : Both Frontend and Backend services needs to be up and running for this application to work end to end
