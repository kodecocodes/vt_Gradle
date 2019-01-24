<!--

OUTLINE: 
Talking about repositories, dependencies and buildscript repositories and dependencies and plugins. Discuss the dependencies task and how to exclude a transitive dependency

-->

The build system manages project dependencies from your local filesystem and from remote repositories. This prevents you from having to manually search, download, and copy binary packages of your dependencies into your project directory.

Let's continue to inspect the root project's `build.gradle` of the Android application we created in the previous video. 

**repositories**
The repositories block configures the repositories Gradle uses to search or download the dependencies. Gradle pre-configures support for remote repositories such as JCenter, Maven Central, and Ivy. You can also use local repositories or define your own remote repositories. The code below defines JCenter as the repository Gradle should use to look for its dependencies. It also includes Google's Maven repository.

Note, we need to specify the repositories to resolve the dependencies of the build itself. That it is the repositories block within buildscript and the repositories used to resolve the dependencies of the different modules.

 We are configuring both `google` and `jcenter` repositories for allprojects. We will discuss the allprojects keyword later in the course when we talk about multi-project builds.

**dependencies**

The dependencies block configures the dependencies Gradle needs to use to build your project. The following line adds Android plugin for Gradle version 3.3.0 as a classpath dependency.

    buildscript {
        ...
        dependencies {
            classpath 'com.android.tools.build:gradle:3.3.0'


You'll see two files named `build.gradle`: one for the project and one for the "app" module. Each module has its own `build.gradle` file, but this project currently has just one module. Open `app/build.gradle`. You can find a dependency block for the module. 

if you run `./gradlew :app:dependencies`, you will see a list of dependencies and its transitive dependencies. 

Often, you may need to exclude a transitive dependency. 

JUnit has harmcrest-core as a transitive dependency.

    \--- junit:junit:4.12
        \--- org.hamcrest:hamcrest-core:1.3
        
replace: 

    testImplementation 'junit:junit:4.12'

with:

    testImplementation('junit:junit:4.12') {
        exclude group: 'org.hamcrest', module: 'hamcrest-core'
    }   

Run `./gradlew dependencies` again and you will see how to harmcrest transitve dependency is no longer included.

    \--- junit:junit:4.12

Understanding how dependencies are resolved and how to work with them is really important to get the most out of your build.
