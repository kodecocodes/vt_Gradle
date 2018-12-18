# Intro

## Requisites

Gradle runs on the JVM. Gradle itself is built with Java but  your build scripts can be written in a Groovy or Kotlin DSL. If you are wonding what a DSL is, DSL is the acronym for a Domain Specific Language. In the case of Gradle, is a DSL for defining your build. The only requisite to run Gradle is a valid JDK installation. Starting from Gradle 5.0, JDK 1.8 is the minimum. 

Please, note that Gradle is not limited to building just JVM projects. During this course we will be using Gradle to build Android applications but Gradle can used for example to build C++ applications or generate static websites.

Thanks to the Gradle wrapper, which we will discuss later in the course, you can built a project without even having Gradle installed in our machines. In fact, that it is quite a common scenario.

## Installing 
 
Let me show how easy is to install Gradle. Note, you can follow along watching the rest of the course without installing Gradle but I recommend you to try it out. 

# Demo

<!-- show Desktop with browser and sdkman.io open -->

The easiest way to install Gradle in a Unix based system is to use SDKMan.  

Installing SDK is just one command in the terminal. 

```bash
$ curl -s "https://get.sdkman.io" | bash
```

I've SDKMan already install in my computer. Once you install SDKMan. You can list every available version of Gradle by typing in your terminal 

```bash
$ sdk list gradle
```

You can install a particular version with : 

```bash
$ sdk install gradle 5.0
```

Change the default version of Gradle with:

```bash
$ sdk default gradle 4.10.3
```

and you can change the version of Gradle you are using at any time with

```bash
$ sdk use gradle 5.0
```

You can even manage your JDK installations with SDKman. 

```
sdk list java
```

As you can see, I have versions of JDK 8 and 11 installed, and I often run terminals with different JDK versions to test my projects work well with both  JDKs. 

Once you have Gradle installed, you can run the interactive `gradle init` command which will guide your through the septs necessary to build a Gradle project.

```bash
$ gradle init
Select type of project to generate:
  1: basic
  2: groovy-application
  3: groovy-library
  4: java-application
  5: java-library
  6: kotlin-application
  7: kotlin-library
  8: scala-library
Enter selection (default: basic) [1..8] : 1
Select build script DSL:
  1: groovy
  2: kotlin
Enter selection (default: groovy) [1..2] 1
```

Congratulations you have successfully created your fist Gradle project. 