<!--

OUTLINE: 
Shows how to keep your android build dry using Extra properties and gradle.properties
-->

# Intro 

<!-- Talking Head -->

There are two kinds of variables that can be declared in a build script: local variables and extra properties.

**Local variables**

Local variables are declared with the def keyword. They are only visible in the scope where they have been declared. 

**Extra Properties**

All enhanced objects in Gradle’s domain model can hold extra user-defined properties. This includes, but is not limited to, projects, tasks, and source sets.

Extra properties can be added, read and set via the owning object’s ext property. Alternatively, an ext block can be used to add multiple properties at once.

<!-- Computer Demo - Android Studio Open to starter -->

We are going to move all the dependency versions to an `ext` block of `app` project. 



    ext {
       appCompatV7Version = '28.0.0'
       constraintsLayoutVersion = '1.1.3'
       junitVersion = '4.12'
       androidTestRunnerVersion = '1.0.2'
       espressoCoreVersion = '3.0.2'
    }

    ...
    ..
    .
    dependencies {
        implementation fileTree(dir: 'libs', include: ['*.jar'])
        implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
        implementation "com.android.support:appcompat-v7:$appCompatV7Version"
        implementation "com.android.support.constraint:constraint-layout:$constraintsLayoutVersion"
        testImplementation("junit:junit:$junitVersion") {
            exclude group: 'org.hamcrest', module: 'hamcrest-core'
        }
        androidTestImplementation "com.android.support.test:runner:${androidTestRunnerVersion}"
        androidTestImplementation "com.android.support.test.espresso:espresso-core:$espressoCoreVersion"
    }

Note we are using Groovy string interpolation capabilities to interpolate the extra property values in the dependencies block.

# Intro Gradle Properties

Gradle provides multiple mechanisms for configuring behavior of Gradle itself and specific projects.

- Command-line flags
- System properties
- Gradle properties
- Environment variables

Gradle provides several options that make it easy to configure the Java process that will be used to execute your build. While it’s possible to configure these in your local environment via GRADLE_OPTS or JAVA_OPTS, it is useful to store certain settings like JVM memory configuration and Java home location in version control so that an entire team can work with a consistent environment.

Setting up a consistent environment for your build is as simple as placing these settings into a `gradle.properties` file. The configuration is applied in following order (if an option is configured in multiple locations the last one wins):

- `gradle.properties` in project root directory.

- `gradle.properties` in GRADLE_USER_HOME directory.

- `system properties`, e.g. when -Dgradle.user.home is set on the command line.
 
# Demo

Let's replace the extra properties block to a gradle.properties in the root of `app` project. 


    appCompatV7Version=28.0.0
    constraintsLayoutVersion=1.1.3
    junitVersion=4.12
    androidTestRunnerVersion=1.0.2
    espressoCoreVersion=3.0.2

We could also add those version definitions to the `gradle.properties` file in the root directory if you think those values will be reused for other modules. 
 
For example, a multi-project build could use a root `gradle.properties` to define version numbers to ensure every module uses the same version in their dependencies.