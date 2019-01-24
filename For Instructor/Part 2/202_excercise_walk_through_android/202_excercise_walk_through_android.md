<!--
OUTLINE: 
In this video we will talk about the Gradle files included when you create an android app and specially we will cover the contents of build.gradle and app/build.gradle. 

Talk about Android Studio Gradle Plugin (AGP) and how it is versioned with releases of Android Studio. Show how Android Studio prompts you to upgrade the AGP and Gradle versions opening a project that references old versions.
-->

# Intro 

Android studios is the default IDE to build Android apps.
The Android Studio build system is based on Gradle, and the Android Gradle plugin adds several features that are specific to building Android apps. Although the Android plugin is typically updated in lock-step with Android Studio, the plugin (and the rest of the Gradle system) can run independent of Android Studio and be updated separately.


# Demo

Create a new app with Android Studio Wizard.

**Create Android Project**

Application name: MyApp
Company domain: android.raywenderlich.com
Project Location: Desktop
Package name: com.raywenderlich.android
[Checked] Include Kotlin Support

**Target Android Devices**

[Check] Phone and Tablet - Api 19 : Android 4.4

**Add an Activity to Mobile**

Empty Activity

**Configure Activity**

Activity Name: Main Activity
[Checked] Generate Layout File

Layout Name: activity_main
[checked] Backwards Compatibility (App Compat)
-->

Let's review the Gradle files included in the project. 

First, we encountered the Gradle wrapper files we discussed previously in the course: 


- `gradle/wrapper/gradle-wrapper.jar` - Gradle Wrapper executable JAR
- `gradle/wrapper/gradle-wrapper.properties` - Gradle Wrapper configuration properties
- `gradlew` - Gradle Wrapper script for Unix-based systems
 - `gradlew.bat` - Gradle Wrapper script for Windows

# The Gradle settings file

The `settings.gradle` file, located in the root project directory, tells Gradle which modules it should include when building your app. By default, a new Android project is already a multi-project build with one root project and one modulle named `app`. The `app` module is included in 
`setting.gradle`.

`include ‘:app’`

# The top-level build file

The top-level `build.gradle` file, located in the root project directory, defines build configurations that apply to all modules in your project. 

By default, the top-level build file uses the buildscript block to define the Gradle repositories and dependencies, for the build, that are common to all modules in the project.

**buildscript**

The buildscript block is where you configure the repositories and dependencies for Gradle itself—meaning, you should not include dependencies for your modules here. For example, this block includes the **Android plugin for Gradle** as a dependency.

**Android plugin for Gradle** provides the additional instructions Gradle needs to build Android app modules.

When you update Android Studio, you may receive a prompt to automatically update the Android Gradle plugin to the latest available version. You can choose to accept the update or manually specify a version based on your project's build requirements.

You can specify the plugin version in either the File > Project Structure > Project menu in Android Studio, or the top-level build.gradle file.

When you update Android Studio, you may receive a prompt to also update Gradle to the latest available version. You can choose to accept the update or manually specify a version based on your project's build requirements.

For the best performance, you should try to use the latest possible version of both Gradle and the plugin.

We will continue to discuss the build file in the next video.