<!--
**OUTLINE**

Explain the difference between Adhoc & Typed tasks and show some useful typed tasks such as Copy or Delete.

-->

# Intro

<!-- Talking Head -->

**[Slide 1]**

Gradle provides APIs for creating and configuring tasks through a Groovy or Kotlin-based DSL. A Project includes a collection of Tasks, each of which performs some basic operation.

In the previous video, we saw how to write an ad-hoc task. 
Ad-hoctasks implementations are written in the build script using `doLast()` or `doFirst()`. 

Typed tasks are not written in the build script but configured in the build scripted. We are going to see an example where the implementation is provided by the `Copy` Class. 

# Demo

<!-- Excercise -->

I've an empty Gradle build as you may obtain if you run the `gradle init` wizard. 

- Create a directory called `src`
- Add a file called `welcome.txt` in the `src` directory. Add a single line _Welcome to Raywenderlich.com!_ to it.
- Define a task called copy of type `Copy` in your build file that copies the `src` directory to a new directory called `dest`.

Use `rw` for group. Creating logic grouping for Gradle tasks helps working with a build. 


    task copy(type: Copy, group: "rw", description: "Copies sources to the dest directory") {
        from "src"
        into "dest"
    }

Execute `./gradlew tasks --all`

You will see the `rw` tasks grouped with the description we provided. 

    ...
    ...
    Rw tasks
    --------
    copy - Copies sources to the dest directory

Execute the task

`./gradlew copy`. 

You can see that a `dest` folder was created and that the file `welcome.txt`was copied into it. 

Create a task to delete the `dest` folder. 

    task delete(type: Copy, group: "rw", description: "Deletes the dest directory") {
        delete 'dest'
    }

Execute the task

`./gradlew delete`. 

You can see that a `dest` folder is deleted.

It is important to keep our build as easy to maintain as possible. We have referenced the `dest` folder twice; in both `copy` and `delete` tasks. If we wanted to change the destination folder name, we will need to update the build file in those two places. A better way is to use reference the copy task destination directory. 

Edit the delete task and replace delete `dest` with `delete copy.destinationDir`.

    task delete(type: Copy, group: "rw", description: "Deletes the dest directory") {
        delete copy.destinationDir
    }
    

Gradle comes with a library of tasks that you can configure in your own projects. We discussed the core type `Copy` and `Delete` but there are many more tasks to help you with the most common build operations. 