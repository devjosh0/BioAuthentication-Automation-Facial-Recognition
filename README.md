# FacialRecognition

FacialRecognition is a Java-based automated test suite for a web application that supports facial recognition sign-up and login. It uses Selenium WebDriver and TestNG to automate browser interactions and validate the facial authentication workflow.

## Features

- Automated sign-up with randomly generated user credentials
- MP4 to Y4M video conversion for facial recognition testing
- Selenium-driven browser automation (Chrome)
- End-to-end test: sign up, set up biometrics, log in with face, and delete account
- TestNG-based test execution and reporting

## Project Structure

```
src/
  main/
    java/
      Pages/      # Page Object Model classes for UI automation
      Utils/      # Utility classes (e.g., video conversion, test data)
    resources/
      face.mp4    # Sample video for facial recognition
      face.y4m    # Converted video for Selenium fake video capture
  test/
    java/
      FaceSignUpTest.java  # Main test class
```

## Key Components

- [`Pages.SignUpPage`](src/main/java/Pages/SignUpPage.java): Automates user registration.
- [`Pages.BiometricsPage`](src/main/java/Pages/BiometricsPage.java): Handles biometric setup.
- [`Pages.LoginPage`](src/main/java/Pages/LoginPage.java): Automates login with facial recognition.
- [`Pages.DeleteAccount`](src/main/java/Pages/DeleteAccount.java): Deletes the test user account.
- [`Utils.ConvertMp4ToY4m`](src/main/java/Utils/ConvertMp4ToY4m.java): Converts MP4 video to Y4M format using FFmpeg.
- [`Utils.TestDataUtils`](src/main/java/Utils/TestDataUtils.java): Generates random test data.
- [`FaceSignUpTest`](src/test/java/FaceSignUpTest.java): Orchestrates the full test flow.

## Prerequisites

- Java 17+
- Maven
- Chrome browser
- FFmpeg (for video conversion)

## How to Run

1. Install dependencies:
   ```sh
   mvn clean install
   ```

2. Run tests:
   ```sh
   mvn test
   ```

## Continuous Integration

- GitHub Actions workflow in [`.github/workflows/main.yml`](.github/workflows/main.yml) runs tests on push and pull requests.
- FFmpeg is installed automatically for video conversion.
- Test reports are archived as artifacts.

## Notes

- The test uses Chrome in headless mode and simulates webcam input using the converted Y4M video.
- Ensure `face.mp4` is present in `src/main/resources/` before running tests.
- The generated `face.y4m` is ignored by Git.

## License

This project is for demonstration
