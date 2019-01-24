https://developer.android.com/studio/build/

A build variant is a cross product of a build type and product flavor, and is the configuration Gradle uses to build your app. Using build variants, you can build the debug version of your product flavors during development, or signed release versions of your product flavors for distribution. Although you do not configure build variants directly, you do configure the build types and product flavors that form them. Creating additional build types or product flavors also creates additional build variants. To learn how to create and manage build variants, read the Configure Build Variants overview.




https://developer.android.com/studio/build/building-cmdline

The "Debug" part in the above task names is just a camel-case version of the build variant name, so it can be replaced with whichever build type or variant you want to assemble or install. For example, if you have a "demo" product flavor, then you can build the debug version with the assembleDemoDebug task.

To see all the build and install tasks available for eac
h variant (including uninstall tasks), run the tasks task.