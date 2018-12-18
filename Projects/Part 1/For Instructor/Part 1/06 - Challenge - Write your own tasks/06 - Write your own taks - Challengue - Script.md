# Intro

In the previous video, we learned how to create and execute a custom Gradle tasks. We will shortly discuss how to create dependencies between tasks but before we can create such dependencies graph we need to create more tasks. In this challenge you should create  new tasks named `gradleVideoTutorial` which prints `Welcome to Gradle Video Tutorial`. 


# Solution

Edit `build.gradle`. To create a task use the `task` keyword.

```groovy
task gradleVideoTutorial {
    doLast() {
    }
}
```

You can execute the task with: 

`/gradlew gradleVideoTutorial`

or with: 

`./gradlew gVT`

Congratulations, you created a new Gradle task. Continue watching to learn how to create dependencies between our tasks. 