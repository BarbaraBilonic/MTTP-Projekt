#
This project contains five tests used to test demo website http://demowebshop.tricentis.com/

## Tools used

Development kit: java JDK <br />
IDE: IntelliJ Community Edition <br />
Driver: ChromeDriver <br />
Automation and management : Maven <br />

## Maven plugins used

Selenium-java <br />
testng <br />
Maven-surefire-report-plugin <br />
Maven-compiler-plugin <br />

##

First you need to have IntelliJ installed as well as java JDK. You also need a CromeDriver. There is already one ChromeDriver in this project however you may need to download another one if this one does not match your version of Chrome. 
You can download ChromeDriver here: https://chromedriver.chromium.org/downloads. <br />
If you use another ChromeDriver you need to change the path to it inside setupTest() method in Test class.

## Running the tests
In the upper toolbar on the left you can choose which test you want to run and clicking run button. You can choose to run all five tests or just one.
You can also run all tests by typing “mvn test” and starting the tests with ctrl+Enter.<br />
### Seeing the report:
You can see generated report of the tests by going to target -> surefire-reports -> old -> index.html, right click on index.htm -> open in browser and choose a browser
