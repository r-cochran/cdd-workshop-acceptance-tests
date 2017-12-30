# Continuous Delivery Workshop Acceptance Tests

This is an external project used to execute the acceptance tests against a standing application (LINK HERE). 

# Requirements

- Java 8
- Maven (3.1 or higher)
- chromedriver

# Setup

define the CHROME_WEB_DRIVER system variable

```
    export CHROME_WEB_DRIVER="path/to/webdriver/chromewebdriver"
```


# Build Commands

Execute the tests

```
mvn clean install
```


Execute the tests targeting a specific port

```
mvn clean install -Dport=8091
```
