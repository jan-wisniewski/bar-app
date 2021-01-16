# bar-app
> App allows you to add products to the database, placing orders, billing and paying for them
> 
## Table of contents
* [Technologies](#technologies)
* [Dependencies](#dependencies)
* [Plugins](#plugins)
* [Setup](#setup)
* [Database](#database)
* [Author](#Author)

## Technologies
#### General:
* Java 11
* Apache Maven 3.6.3
* Spring Boot 2.4.1
* JPA (Hibernate) 2.4.1

## Dependencies:

###### Compile:

* springfox-swagger-ui	2.9.2
* springfox-swagger2	2.9.2
* spring-boot-starter-data-jpa	2.4.1
* spring-boot-starter-web	2.4.1
* lombok	1.18.16

###### Runtime

* h2	1.4.200
* spring-boot-devtools	2.4.1

###### Test

* mockito-core	3.6.28
* mockito-junit-jupiter	3.6.28
* spring-boot-starter-test	2.4.1

#### Plugins:
* maven-clean-plugin	3.1.0
* maven-compiler-plugin	3.8.1
* maven-deploy-plugin	2.8.2
* maven-install-plugin	2.5.2
* maven-jar-plugin	3.2.0
* maven-site-plugin	3.9.0
* maven-surefire-plugin	2.22.2
* boot-maven-plugin	2.4.1
* maven-resources-plugin	3.2.0
* maven-project-info-reports-plugin 3.1.1

## Setup
1. Build application from root directory of project and run command

`mvn clean install`

2. Start Spring Boot App via terminal by typing

`mvn spring-boot:run`

3. After starting app you can use Swagger to test REST API. Swagger is available at 

`http://localhost:8080/swagger-ui.html`

4. Fristly, you should add some products to the database at 

`http://localhost:8080/api/product/create`

5. After that you can place the order at

`http://localhost:8080/api/order/create`

6. Then you can bill the order

`http://localhost:8080/api/order/{orderId}/bill`

7. And pay for this order

`http://localhost:8080/api/order/{orderId}/payment`

## Database
The application has a built-in h2 database. To enter the database and view entries, go to.
Login and password to h2 database are stores ad application.properties file
`http://localhost:8080/h2-console`


## Author
Jan Wiśniewski
