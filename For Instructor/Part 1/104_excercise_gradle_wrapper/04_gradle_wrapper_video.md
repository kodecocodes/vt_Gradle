<!--
**OUTLINE**

Talking Head: I will explain the viewers about Gradle wrapper. 

Show Gradle tasks. 	

Demo: Create a sample skeleton with gradle init. Show how to create a gradle project with IntelliJ or with Android Studio. I will show how to run gradle wrapper and run a task. ./gradlew tasks --all

-->

# Intro

The Gradle Wrapper is the recommended way to invoke any Gradle build. 

The Wrapper is a script that invokes a declared version of Gradle, downloading it beforehand if necessary. 

What are the advantages?

- Developers can use any Gradle build without even having Gradle installed in their machines. 
- It standardises a project on a given Gradle version, leading to more reliable and robust builds.
- Provisioning a new Gradle version to different users and execution environment (e.g. IDEs or Continuous Integration servers) is as simple as changing the Wrapper definition. 

Let me show you how easy is to work with the Gradle wrapper.

<!-- Shows MacOS terminal -->

I am currently using gradle 4.10.2

```bash
gradle -version
------------------------------------------------------------
Gradle 4.10.2
------------------------------------------------------------
```

You can execute 

```bash
gradle wrapper
```

and the Wrapper files will be generated. 

**[Slide 01]**

Those files are:

- `gradlew`. A shell script for executing the build with the Wrapper.
- `gradlew.bat` A Windows batch script for executing the build with the Wrapper.
- `gradle/wrapper/gradle-wrapper.properties` A properties file responsible for configuring the Wrapper runtime behavior e.g. the Gradle version compatible with this version.
- `gradle/wrapper/gradle-wrapper.jar`. The Wrapper JAR file containing code for downloading the Gradle distribution.

You should commit these four files in your version control system. 

# Using the Gradle Wrapper

We should always work with the Wrapper to invoke tasks in our builds. 

We can execute the help task with:

```bash
./gradlew help`
```

# Upgrading the Gradle Wrapper

You should strive to upgrade the Gradle version of your projects to benefit from new features and improvements. Although we could upgrade the Gradle version manually changing the `distributionUrl` property in the Wrapper property file.  

<!-- Cat the gradle property and highlight the version --> 
```bash
$ cat gradle/wrapper/gradle-wrapper.properties
```

The recommended approach is to invoke the gradle wrapper task  and provide the target Gradle version. 

```bash
$ ./gradlew wrapper --gradle-version 5.1
```

Using the wrapper task ensures that any optimizations made to the Wrapper shell script or batch file with that specific Gradle version are applied to the project.

Lets check if the version got upgraded:

```bash
$ ./gradlew -v
```

Congratulations, we have updated our project to gradle 5.1. The latest stable version of Gradle by the time of this recording. 

During the rest of the course, we will use always the Wrapper to invoke our build tasks.