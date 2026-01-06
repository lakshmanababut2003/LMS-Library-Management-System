Java Library Management (Beginner Guide)

This project is a Java project created using Visual Studio Code.
This file explains how libraries (JAR files) are managed in this project.

Project Folder Structure
project-root
│
├── src    → Java source files
├── lib    → External library (JAR) files
├── bin    → Compiled `.class` files


Write your Java code inside the src folder

Add required JAR files inside the lib folder

VS Code generates compiled files automatically in bin

Adding Libraries (JAR Files)

If your project needs external libraries (example: MySQL, Gson, etc.):

Download the required .jar file

Copy the file into the lib folder

Open VS Code

Go to JAVA PROJECTS panel

Under Referenced Libraries, ensure the JAR file is added

VS Code will automatically link the library to the project.

Managing Libraries in VS Code

All added libraries are shown under Referenced Libraries

You can add or remove JAR files anytime

No manual classpath configuration is required

Notes

This project uses manual library management

No Maven or Gradle is used

Suitable for learning, practice, and small Java projects
