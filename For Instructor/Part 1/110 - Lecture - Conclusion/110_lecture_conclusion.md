<!--
**OUTLINE**
Create a Gradle project, apply the base plugin and create two task which execute when you invoke `build `and run one after the other.
-->

# Intro

<!-- Talking Head -->

In this challenge, you need to create two tasks named `build`, `test`. When you invoke `build`, `test` must be run first.

# Solution

Edit `build.gradle`. To create a task use the `task` keyword.

    task test {
        group 'rw'
        doLast {
            logger.quiet 'test'
        }
    }

Create another task named `build`

    task build {
        group 'rw'
        dependsOn test
        doLast {
            logger.quiet 'build'
        }
    }

Note, you can defined the dependsOn relationship in the task declaration. 

Execute 

`/gradlew build`


Congratulations, you learned how to create dependencies between our tasks. Continue watching to learn about Gradle in the Android context. 