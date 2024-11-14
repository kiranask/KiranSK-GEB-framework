KiranSK-GEB-Framework
Overview
KiranSK-GEB-Framework is a front-end automation framework developed using Groovy, leveraging GEB for browser automation and integrating Selenium and Appium for web and mobile application testing. This framework is designed to provide a scalable and maintainable solution for cross-platform automation testing, enabling easy interaction with web elements and mobile applications using concise and intuitive syntax.

Key Features
Cross-platform support: Test automation for both web and mobile applications.
GEB Syntax: Built on GEB, a Groovy-based automation framework that makes writing tests simpler and more expressive.
Selenium & Appium Integration: Facilitates seamless browser and mobile automation.
Page Object Model (POM): Maintains code modularity and reusability.
Extensible: Easily customizable to fit various testing requirements.
Parallel Execution: Supports running multiple tests concurrently, improving test coverage and reducing execution time.
Prerequisites
Java Development Kit (JDK): JDK 8 or higher.
Groovy: Ensure Groovy is installed and configured in your environment.
Selenium WebDriver: Version 3.141.59 or higher.
Appium Server: For mobile automation; Appium version 1.20 or higher.
Browser Drivers: ChromeDriver, GeckoDriver, etc., based on the target browser.
Gradle: The framework is configured with Gradle as the build tool.
Getting Started
1. Clone the Repository
bash
Copy code
git clone https://github.com/your-username/KiranSK-GEB-Framework.git
cd KiranSK-GEB-Framework
2. Install Dependencies
Make sure all dependencies are configured in the build.gradle file. To install dependencies, run:

bash
Copy code
./gradlew clean build
3. Set Up Environment Variables
Create environment variables required for test configurations, such as:

BROWSER (e.g., Chrome, Firefox)
BASE_URL (URL of the application under test)
PLATFORM (Web or Mobile)
DEVICE_NAME (for mobile testing)
4. Configure Test Capabilities
Define the WebDriver and Appium capabilities in the GebConfig.groovy file.

Example configuration:
