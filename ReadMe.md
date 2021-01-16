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
1. Build Application 
   
To build application from root directory of project run command

`mvn clean install`

2. Spring Boot

Start Spring Boot App via terminal by typing

`mvn spring-boot:run`

3. Swagger

After starting app you can use Swagger to test REST API. Swagger is available at 

`http://localhost:8080/swagger-ui.html`

4. Adding Product

Fristly, you should add some products to the database. In Swagger go to the below tab. Press "Try it out" button and complete JSON request. The most important are name and price of the product.
   
ID can remain set to 0 because a new ID will be generated after the entity has been correctly added to the database so please check "Response Body" section after adding product correctly.

`/api/product/create`

5. Create Order

After adding products, you can place the order at `/api/order/create`. As previously please complete JSON request. If you don't remember ID's of added product, you can check all of the products stored in database at `/api/product/all`

Important! Please remember order ID which will be display at "Response Body" section. 

5. Generate Bill

Before you be able to pay for the order, you need to generate a bill. To do this, go to

`api/order/{orderId}/bill`

As previously, ID in JSON can remain set to 0.

6. Pay For The Order

You need to pay the generated bill to complete the entire ordering process.

Payments type are defined at PaymentType class

`/api/order/{orderId}/payment`

## Database
The application has a built-in h2 database. To enter the database and view entries, go to.
Login and password to h2 database are stores ad application.properties file
`http://localhost:8080/h2-console`


## Author
Jan Wiśniewski
