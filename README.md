# Simple RESTful Web Service
--------------------------------------

Simple RESTful web service with full support of CRUD. Based on the [Spring "Building a RESTful Web Service" tutorial](https://spring.io/guides/gs/rest-service/).

## Requirements

To build the project you will need 
 
- [JAVA 1.6 or later](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
- [Maven 3.0+](http://maven.apache.org/)
- a tool to send POST request, e.g. [cUrl](http://curl.haxx.se/)

## Build and run

1. Run build.bat file or type the following line in console from project folder:

 ```
 mvn clean package
 ```

2. Run run.bat file or type the following line in console from project folder:

 ```
 java -jar target\gs-rest-service-0.1.0.jar
 ```

3. To check type url

 ```
 http://localhost:8080/view
 ```

 in any browser.

## API specification

1. Show all current entries
 - Method: GET 
 - Url: `http://localhost:8080/view`

2. Create a new entry
 - Method: POST 
 - Url: `http://localhost:8080/create`
 - Parameters: name, password
 - Sending request with cUrl:
 ```
 curl -X POST -v -d "username=user4" -d "password=pass4" http://localhost:8080/create
 ```

3. Update an existing entry
 - Method: POST 
 - Url: `http://localhost:8080/update`
 - Parameters: name, password
 - Sending request with cUrl:
 ```
 curl -X POST -v -d "username=Tzeench" -d "password=qwerty123456" http://localhost:8080/update
 ```

4. Delete an existing entry by name
 - Method: POST 
 - Url: `http://localhost:8080/delete`
 - Parameters: name
 - Sending request with cUrl:
 ```
 curl -X POST -v -d "username=user1" "http://localhost:8080/delete"
 ```
