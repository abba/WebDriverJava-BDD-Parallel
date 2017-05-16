##Requirements

Windows/Linux/Mac,
Maven,
Java JDK 8,
Google Chrome,

Libraries and Frameworks
Selenium WebDriver
 
JUnit

Cucumber-JVM

Parallel

Hamcrest

Cucumber Reports


##Test Execution

**Parallel Test Run**
###CLI Command: 
mvn <goal> -P <profile> -D<forNumber.i.e. enough JVMs to Run Tests>

e.g mvn test -P Parallel-Tests -Dsurefire.forkNumber=10


**Non - Parallel Tests**
###CLI Command:
mvn <goal> -P <profile> -Dcucumber.options<optional for specific tags>

mvn test -P Non-Parallel-Tests

mvn test -P Non-Parallel-Tests -Dcucumber.options="-t @search"
