# campoTreinamento-web-selenium

CampoTreinamento is a web application created to be tested using a test framework.

The framework chosen is Selenium Webdriver, and the web app was presented in this [Udemy course](https://www.udemy.com/course/testes-funcionais-com-selenium-webdriver/).

## Prerequisites

The versions defined below can be equal or higher:

- Maven 3.8.6;

- JDK 18.0.2.1;

- JUnit 5.10.0;

- Selenium Webdriver 4.12.1;

- Mozilla Firefox 117.0.1.

## Usage

To use this project, clone it on your machine and open on your favorite IDE.

To run the test automation, you can run all the test cases located at the ``src/main/java/`` dir.

Note 1: the web application is not hosted on a server. The automation will test the ``src/main/resources/componentes.html`` file.

Note 2: the geckodriver used is located at the ``src/main/resources`` dir.

## References

[Selenium Webdriver documentation](https://www.selenium.dev/documentation/webdriver/)

[Selenium Webdriver course on Udemy](https://www.udemy.com/course/testes-funcionais-com-selenium-webdriver/)