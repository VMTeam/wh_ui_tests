* **Clone project**
* **Open in IntelliJ IDEA and wait while gradle doesn't stop configure project.**

### Environment
#### For local test

**Add to Run/Debug configuration -> Templates -> junit**

 * -Dselenide.savePageSource=false
 * -Dselenide.timeout=25000
 * -Dselenide.fastSetValue=true
 * -Dselenide.screenshots=false
 * -Dselenide.baseUrl=localhost:4200

---
### Setup Selenoid
**On Linux**
* cd path/to/project/selenoid
* Run `./cm selenoid start --vnc --browsers-json config/browsers.json --force`
* Run `./cm selenoid-ui start`
* Open in browser http://localhost:8080/ to view test execution

**On Windows**
* cd path/to/project/selenoid
* Run `./cm_wind selenoid start --vnc --browsers-json config/browsers.json --force`
* Run `./cm_wind selenoid-ui start`
* Open in browser http://localhost:8080/ to view test execution

### Run

* Linux `./gradlew test allureReport`
* Windows `gradlew test allureReport`

* Generated Allure report `/build/reports/allure-report`
