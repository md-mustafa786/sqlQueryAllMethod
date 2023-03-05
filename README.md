# sqlQueryAllMethod
*   In this Project I have practice many sql query Methods.
##  Framework and Language use in this Project-
 *  Springboot
 *  Java
##  Dependencies
 *  Spring Web
 *  MySql Database
 *  Spring Boot DevTools
 *  Lombok 
 *  Spring Data JPA
 
### Requirments
 * IntelliJIDEA
 * Serverport: 3306
 * Java version: 17
 * Everything is present in the pom.xml (no need to download any library)
### Steps to run Application
 * Download the source code and import in intellijIDEA.
 * Go to localhost:8080/
 * Type endpoints in the post-man
 * If need then provide RequestBody in json format and Path-variable or path-param.
 
 User will perform following operations - 
 ##### 1) - Add Student Info - 
       * Home - localhost:8080/
       * Endpoint -/add-data

 
 ##### 2) - find data by Student first Name - 
  ##### -> EndPoints:
       * Home - localhost:8080/
       * Endpoint - /find-by-firstName
 
 
 
 ##### 3) -  find data by Student first Name And Last Name - 
 ##### -> EndPoints:
       * Home - localhost:8080/
       * Endpoint -/find-by-first/last-name
 
 
 ##### 4) - find all Student data who are active-
 ##### -> EndPoints:
       * Home - localhost:8080/
       * Endpoint -/findByActive
 
 #### 5) - update student first name by student id-
 #### ->  EndPoints:
       * Home - localhost:8080/
       * Endpoint -updateFirstName/{Id}/{firstName}

 ##### 5) - Delete Student data by first name-
 ##### -> EndPoints:
       * Home - localhost:8080/
       * Endpoint -/deleteByFirstName
       
 ##### 5) - find student data by createdDate-
 ##### -> EndPoints:
       * Home - localhost:8080/
       * Endpoint -/findByDate
 


### Note
* You can change server port by application.properties file i.e.

        server.port=8081
 
