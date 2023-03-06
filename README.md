# Supralog Technical Test 

## How to run ?

### Create MongoDB and MongoExpress

- Run the command `docker-compose up`
- MongoDB is on the port 27017
- MongoDB is on the port 8081


### Run the application

- Run mongoDB docker
- Run the command `mvn clean install` in the api restful project that you want to start
- Run the command `mvn spring-boot:run`
- Happy hacking


## How it work ?

### Register a user (users-register)

- POST http://localhost:9001/api/v1/users
- Body : <br>
  {<br>
    "firstName": "john", <br>
    "lastName": "doe", <br>
    "birthDate": "2008-06-02", <br>
    "gender": "MALE", <br>
    "mail": "john.doe@domain.com", <br>
    "password": "Password123", <br>
    "role": "ADMIN", <br>
    "nationality": "FRANCE", <br>
    "phoneNumber": "+33712345678" //optional <br>
    "zipCode": "06220" //optional <br>
    
 }

### List users (users-access)

- GET http://localhost:9000/api/v1/users

### Find user by id (users-access)

- GET http://localhost:9000/api/v1/users/:id

### Find user by mail (users-access)

- GET http://localhost:9000/users?mail=mail

### Run tests

- Run the command `mvn clean install`
- Run the command `mvn test` on the project folder
