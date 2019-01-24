<!--

Outline: Discuss Common gradle tasks in Android project and show them in the Android Studio UI and in a terminal. 

--> 

Gradle and the Android plugin run independent of Android Studio. This means that you can build your Android apps from within Android Studio, the command line on your machine, or on machines where Android Studio is not installed (such as continuous integration servers)

The output of the build is the same whether you are building a project from the command line, on a remote machine, or using Android Studio.

You can execute all the build tasks available to your Android project using the Gradle wrapper command line tool. It's available as a batch file for Windows (`gradlew.bat`) and a shell script for Linux and Mac (`gradlew`), and it's accessible from the root of each project you create with Android Studio.


# DEMO

## Unit Tests

<!-- Showing Android Studio ->

The Android Plugin for Gradle lets you run unit tests from your Gradle project via the command-line. 

- Open Terminal in Android Studio. 
- Execute `$ ./gradlew :app:test --console=plain`

`--console=plain` flag sets the console output to plain to generate plain text only. This option disables all color and other rich output in the console output. This is the default when Gradle is not attached to a terminal.

As the output shows, both `testDebugUnitTest` and `testReleaseUnitTest` tasks are executed. 

If you want to run unit tests only for debug. You can execute `$ ./gradlew :app:testDebugUnitTest --console=plain`

Gradle saves test reports in the build/ directory of each module that it tests. You can see the HTML tests results. 

`open app/build/reports/tests/testDebugUnitTest/index.html` 

If you want to see information in the console about tests being executed you can add: 

    android {
        ...
        testOptions {
            unitTests {
                all {
                    testLogging {
                        exceptionFormat "full"
                        events "skipped", "passed", "failed"
                        showStandardStreams true
                    }
                }
            }
        } 
    }


Gradle also allows you to target specific tests using the `--tests` flag. For example, run: 

./gradlew :app:testDebugUnitTest --tests com.raywenderlich.android.myapplication.ExampleUnitTest

to execute just the `ExampleUnitTest`. 

## Android Instrumentation Tests

There is an out-of-the-box Gradle task called `connectedAndroidTest` that can be used to run Instrumentation Tests. This task builds the app and tests and runs them on all connected devices (real or emulated).

I have one emulator running. If I run:

    ./gradlew connectedAndroidTest
    
An instrumented unit test in my project gets executed. 

I can open the tests reports: 

`open app/build/reports/androidTests/connected/index.html`     

Gradle supports task name abbreviations. This means, for example, you can initiate the connectedAndroidTest task by simply entering the following command.

    ./gradlew cAT


## Build a debug APK

For immediate app testing and debugging, you can build a debug APK. The debug APK is signed with a debug key provided by the SDK tools and allows debugging through `adb`.

To build a debug APK, open a command line and navigate to the root of your project directory. To initiate a debug build, invoke the assembleDebug task:

`gradlew assembleDebug`

This creates an APK named `app-debug.apk` in `app/build/outputs/apk/debug/`. The file is already signed with the debug key and aligned with zipalign, so you can immediately install it on a device.

Or to build the APK and immediately install it on a running emulator or connected device, instead invoke installDebug:

`gradlew installDebug`



