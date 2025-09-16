# British Spoken Time Converter

A Java program to convert time in "HH:MM" format to British spoken form.

## Project Structure
- `src/main/java/BritishSpokenTime.java`: Main application logic.
- `src/test/java/BritishSpokenTimeTest.java`: Unit tests using JUnit 5.

## Prerequisites
- Java 1.8 (Amazon Coretto).
- No other dependencies; Gradle handles everything.

## Building and Running with Gradle
This project uses Gradle for build automation. The Gradle Wrapper is included, so no separate Gradle installation is needed.

1. Clone the repository: `git clone git@github.com:rajvipul/SmartBear-Coding-Challenge.git`
2. Navigate to the root directory: `cd SmartBear-Coding-Challenge`
3. Build the project (compiles and runs tests): `./gradlew build` (Unix/Mac) or `gradlew.bat build` (Windows)
4. Run the application: `./gradlew run --args "12:00"`
    - Enter a time like "12:00" in argument. → Output: "noon"

## Running Tests
- Run all unit tests: `./gradlew test`

## Quality Standards
- Adheres to Java best practices (e.g., exception handling, collections usage).
- Clean, readable code.
- Suitable for production.