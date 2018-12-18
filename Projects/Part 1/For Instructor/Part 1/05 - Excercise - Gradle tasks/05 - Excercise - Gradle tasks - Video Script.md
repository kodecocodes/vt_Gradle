# Intro

Everything in Gradle sits on top of two basic concepts: projects and tasks. Each project is made up of one or more tasks. A task represents some atomic piece of work which a build performs. This might be compiling some classes, creating a JAR, generating Javadoc, or publishing some archives to a repository.

When you run a Gradle build using the `gradlew` command, it looks for a file called `build.gradle` in the current directory.
The build script is named `build.gradle` or `build.gradle.kts` if you are using Gradle Kotlin DSL. 

Let's create a build script file in the root of our project.

```bash
touch build.gradle
```

Edit `build.gradle` file and create our first task:

```groovy
task helloRw {
    doLast {
        println 'Welcome to Raywenderlich.com'
    }
}
```

We can now invoke the task:

```bash
./gradlew helloRw

> Task :helloRw
Welcome to Raywenderlich.com

BUILD SUCCESSFUL in 1s
1 actionable task: 1 executed
```

Let's recap what just happened. We defined a task, called `helloRw`, and added an action to it. When we run `gradlew helloRw`, Gradle executes the `helloRw` task, which in turn executes the action we provided. The action is simply a block containing some code to execute.

You could invoke the task with the -q command line option, which suppresses Gradle's log messages, so that only the output of the task is shown.

```bash
./gradlew -q helloRw
```

Gradle has a nice feature to invoke tasks quickly. Instead of writing `helloRw`, I could just write `hR`. 

```bash
./gradlew hR
```

An important thing to bear in mind is that build scripts are code snippets. 

I could use Groovy string capabilities to write a nicer output for our task: 

```groovy
task helloRw {
    doLast {
        println '*' * 50
        println 'Welcome to Raywenderlich.com'
        println '*' * 50
    }
}
```

Groovy overloads multiplier operator and it eases the creation of strings of a predefined length.

```
$ ./gradlew hR

> Task :helloRw
**************************************************
Welcome to Raywenderlich.com
**************************************************

BUILD SUCCESSFUL in 1s
1 actionable task: 1 executed
```

# Build Lifecycle

<!-- Talking head --> 

Build scripts are strictly speaking build configuration scripts since they configure a dependency graph. Every task in our build forms a Direct Acyclic Graph which guarantees that the tasks are executed in the ordered defined by their dependencies and that each task is executed only once. 

**[Slide 01]**

A Gradle build has three distinct phases.

**Initialization**
Gradle supports single and multi-project builds. We will talk later in the course about multi-project builds. During the initialization phase, Gradle determines which projects are going to take part in the build, and creates a Project instance for each of these projects.

**Configuration**
During this phase the project objects are configured. The build scripts of all projects which are part of the build are executed.

**Execution**
Gradle determines the subset of the tasks, created and configured during the configuration phase, to be executed. The subset is determined by the task name arguments passed to the Gradle command and the current directory. Gradle then executes each of the selected tasks.

We will talk later about performance in our builds but one important piece of advice is to keep work out of our configuration phase. Imagine we create a second task our build:

```groovy
task gradleVideoCourse {
    println 'Learn about Gradle!'
}
```

Instead of placing the code snippet in a `doLast` block as we did for the `helloRw', we naively placed it inside the task closure. Since Gradle needs to traverse the whole build file during the configuration phase, independently of the task being executed, we are forcing our build to execute this code block even if we don't want to run the `gradleVideoCourse` task. 

If we execute the `helloRw`, you can see that the `gradleVideoCourse` code is executed also.

```bash
$ ./gradlew helloRw -q --console=plain
Learn about Gradle
**************************************************
Welcome to Raywenderlich.com
**************************************************
```

To fix it place it in a doLast block which ensures the execution of this piece of code happens only if the task is invoked. 

```groovy
task gradleVideoCourse {
    doLast() {
       println 'Learn about Gradle!'
    }
}
```

```bash
$ ./gradlew helloRw -q --console=plain
**************************************************
Welcome to Raywenderlich.com
**************************************************
```
 

