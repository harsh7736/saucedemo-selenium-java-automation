# Saucedemo Selenium Java Automation Suite

[![Build](https://img.shields.io/badge/build-passing-brightgreen)](https://github.com/harsh7736/saucedemo-selenium-java-automation/actions)
[![Selenium](https://img.shields.io/badge/Selenium-WebDriver-blue)](https://www.selenium.dev/)
[![TestNG](https://img.shields.io/badge/TestNG-Framework-orange)](https://testng.org/)
[![Maven](https://img.shields.io/badge/Maven-Build-yellow)](https://maven.apache.org/)
[![Jenkins](https://img.shields.io/badge/CI%2FCD-Jenkins-red)](https://www.jenkins.io/)
[![Extent Reports](https://img.shields.io/badge/Reporting-ExtentReports-purple)](https://www.extentreports.com/)


## 📌 Project Description
This is an **automated testing suite for [saucedemo.com](https://www.saucedemo.com)**, designed to validate core e-commerce functionalities including:
- Login and authentication  
- Product selection  
- Cart management  
- Checkout flow  

The framework is built using Java, Selenium WebDriver, TestNG, and Maven, with robust reporting and CI/CD integration.

---

## 🛠️ Tools & Frameworks Used
- **Selenium WebDriver** – For web UI automation  
- **TestNG** – For test orchestration and annotations (DataProvider, parallel execution, listeners)  
- **Maven** – Build and dependency management  
- **Extent Reports** – For detailed, interactive HTML reporting  
- **TestNG Listeners** – For screenshot capture on failure  
- **CI/CD** – Integrated and executed via Jenkins  
- **Page Object Model & Page Factory** – For clean and maintainable code structure  
- **External JSON Data Source** – For test data parameterization  
- **Global Properties Class** – Allows running tests on different browsers by setting a global value  

---

## ▶️ How to Run Tests
You can run the suite in two ways:

### **1. From IDE (Eclipse/IntelliJ)**
- Right-click on the `testng.xml` file  
- Select **Run As → TestNG Suite**

### **2. From Terminal**
"```bash
mvn clean test"




##📊 Reporting

- **Extent Reports** – Automatically generated in the project directory after each test run.  
- **Screenshots on Failure** – Captured automatically via TestNG Listeners and stored in the designated folder.  
- **Flaky Test Handling** – Implemented to improve test reliability.



## 📷 Sample Outputs

- **Extent Report**  
  ![Extent Report](https://raw.githubusercontent.com/harsh7736/saucedemo-selenium-java-automation/f4ee88d5564b096ac004e4b04aa1d6037aea0cc2/Extent-Report-Screenshot.png)  

- **Jenkins Build Success**  
  ![Jenkins Build Success](screenshots/jenkins-build-success.png)  


##📂 Project Highlights

- **Parallel test execution** enabled
- **CI/CD Integration**
- **Data-driven testing** via TestNG DataProvider  
- **Error validation test cases** included  
- **Browser flexibility** via global properties (`chrome`, `firefox`, etc.)  



##👤 Author

Harsh Singh
GitHub: harsh7736
