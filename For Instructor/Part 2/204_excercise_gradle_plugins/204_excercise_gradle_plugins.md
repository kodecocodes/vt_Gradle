<!--

OUTLINE: 
In this video we talk about how Gradle plugins and how to enhance an Android build adding more plugins. 

Talk about  com.github.ben-manes.versions plugin and stats: https://plugins.gradle.org/plugin/org.kordamp.gradle.stats

-->

# Demo

Often, you will want to enhance your build's functionality. Fortunately, Gradle has a rich plugin ecosystem. 

Gradle's plugin portal should be your first destination when are searching for a plugin. 

<!-- visit https://plugins.gradle.org -->


As you can see, there are many plugins. We are going to install a Gradle plugin for discovering dependency updates. 

Search for `version dependency updates`. 

click `com.github.ben-manes.versions`

As you can see we have instructions to install the plugin. 

Add to the root project's builscript block both the repository: 

    maven {
      url "https://plugins.gradle.org/m2/"
    }

and the dependency: 

        classpath "com.github.ben-manes:gradle-versions-plugin:0.20.0"

Apply the plugin at `app/build.gradle`

apply plugin: "com.github.ben-manes.versions"

Gradle plugins normally are distributed as Open source project typically hosted in Github, Gitlab or Bitbucket. Plugin's author normally list instructions about how to configure the plugin or which tasks the plugin exposes. 

Click the Github link at the Gradle Plugins portal plugin page to learn more. 

This plugin exposes a task named `dependencyUpdates`. Run it:

`./gradlew dependencyUpdates`

As you can see the plugin informs us that we could upgrade the Kotlin version to 1.3.11 and Gradle to 5.1.1.

Versions plugin is one useful plugin for your tool-belt. 

Make sure to visit the Gradle portal plugin (https://plugins.gradle.org) to learn more. 