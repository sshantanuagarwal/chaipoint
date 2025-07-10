# ChaiPoint Java Project

## Project Structure

This project now follows the standard Maven directory layout:

```
chaipoint/
  ├── src/
  │   ├── main/
  │   │   └── java/
  │   │       └── org/
  │   │           └── chaipoint/
  │   │               ├── Application.java
  │   │               ├── ...
  │   │               ├── exceptions/
  │   │               ├── recipe/
  │   │               └── shared/
  │   └── test/
  │       └── java/
  │           └── org/
  │               └── chaipoint/
  │                   ├── ApplicationTest.java
  │                   └── ...
  └── .gitignore
```

## Building and Running

If you want to use Maven or Gradle, add a `pom.xml` or `build.gradle` file at the root. For now, you can compile and run using `javac` and `java`:

```
# Compile all sources
javac -d out $(find src/main/java -name '*.java')

# Run the main class (example)
java -cp out org.chaipoint.Application
```

## Notes
- All `.class` files and build artifacts are now ignored via `.gitignore`.
- Source code is under `src/main/java`, and tests are under `src/test/java`. 