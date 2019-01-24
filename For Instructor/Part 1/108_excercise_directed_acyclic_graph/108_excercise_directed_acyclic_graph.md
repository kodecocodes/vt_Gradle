<!--

**OUTLINE**

Talking head. Directed Acyclic Graph. 
Demo about dependsOn, mustRunAfter, finalizedBy. Explain group

-->

# Intro

<!-- Talking Head -->

Gradle is a language for dependency based programming. In Gradle terms this means that you can define tasks and dependencies between tasks. Gradle guarantees that these tasks are executed in the order of their dependencies, and that each task is executed only once. These tasks form a *Directed Acyclic Graph*. 

 Gradle builds the complete dependency graph before any task is executed.
 
# Demo

<!-- Excercise -->

We are going to create four tasks to emulate tasks which you will typically encounter when you build software and create dependencies between them. 

Create a task for `unitTests`.


    task unitTests {
        group 'verification'
        doLast {
            logger.quiet "Executing unit tests"
        }
    }

We use `verification` as a group. The task group is used in reports and user interfaces to group related tasks together when presenting a list of tasks to the user.

Instead of using a `println` statement we are using the Gradle logger. Gradle defines 6 log levels. One of the them is `quiet` which is reserved for important information messages.

Create an additional tasks for `functionalTests`.

    task functionalTests {
        group 'verification'
        doLast {
            logger.quiet "Executing functional tests"
        }
    }


Now create a task named `check`. Invoking `check` should trigger the invocation of both `unitTests` and `functionalTests`.


    task check {
        group 'verification'
        doLast {
            logger.quiet "Executing Check"
        }
    }


To create such as dependency we can use `dependsOn`. 

    `check.dependsOn functionalTests, unitTests`

If we run `./gradlew check` you can see a graph of

    `functionalTests` -> `unitTests` -> `check`

We can ensure that if in the task graph both `unitTests` and `functionalTests` are present, the `unitTests` task is executed first. To do that use `mustRunAfter` keyword:

`functionalTests.mustRunAfter unitTests`

If you execute `./gradlew check` again you can see a graph of

    `unitTests` -> `functionalTests` ->  -> `check`
    

Note: if you execute 

    ./gradlew functionalTests

the `unitTests` is not executed. `mustRunAfter` ensure the execution order only if both tasks will be run.

Typically  you want to generate reports once every verification has completed. 

Create a new task named `report`:

    task report {
        group 'documentation'
        doLast {
            logger.quiet "Executing report"
        }
    }
    
We can set `report` to be a finalizer task of `check`.
    
    check.finalizedBy report

Finalizer tasks are useful in situations where the build creates a resource that has to be cleaned up regardless of the build failing or succeeding. An example of such a resource is a web container that is started before an integration test task and which should be always shut down, even if some of the tests fail.
    