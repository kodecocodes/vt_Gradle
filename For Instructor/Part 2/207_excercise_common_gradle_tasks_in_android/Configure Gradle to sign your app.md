Configure Gradle to sign your app

Open the module-level build.gradle file and add the signingConfigs {} block with entries for storeFile, storePassword, keyAlias and keyPassword, and then pass that object to the signingConfig property in your build type. For example:

android {
    ...
    defaultConfig { ... }
    signingConfigs {
        release {
            // You need to specify either an absolute path or include the
            // keystore file in the same directory as the build.gradle file.
            storeFile file("my-release-key.jks")
            storePassword "password"
            keyAlias "my-alias"
            keyPassword "password"
        }
    }
    buildTypes {
        release {
            signingConfig signingConfigs.release
            ...
        }
    }
}
Note: In this case, the keystore and key password are visible directly in the build.gradle file. For improved security, you should remove the signing information from your build file.
Now, when you build your app by invoking a Gradle task, Gradle signs your app (and runs zipalign) for you.

Additionally, because you've configured the release build with your signing key, the "install" task is available for that build type. So you can build, align, sign, and install the release APK on an emulator or device all with the installRelease task.