# DataBases
The task have to be performed on the basis of the designed database model from lab. works No. 1 and the developed script in lab No. 3.

The database must be deployed using an SQL script.

The program should be created as Maven project with MySQL connection.

The project structure is created on the basis of MVC-pattern. Where the model must contain both a Database Access Layer, and a Business Logic Layer. Implementation of Database Access level performed on the basis of DAO-pattern.

User Interface Layer is implemented as a console application. The program must work with data in the database using JDBC:

output of data from tables
insert data into the table
delete data from the table
update data in tables
Connect the following plugins to Maven:

FindBugs
PMD
Checkstyle
To run:

download project files git clone https://github.com/Olehbalo/database/edit/lab6

switch to Lab6 branch git checkout Lab6

compile maven project mvn compile

package compiled code into .jar mvn package

run application: java -cp target\Lab6-1.0-SNAPSHOT.jar ua.lviv.iot.App

to check API go to http://localhost:8081/swagger-ui.html#/:

Pick table

Pick method that you want to test

Type in body for request in JSON format(if body required)

run checkstyle: mvn checkstyle:check

check for bugs mvn findbugs:gui

check for dublications in code mvn pmd:pmd
