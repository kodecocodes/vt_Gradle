plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(27)
    defaultConfig {
        applicationId = "com.raywenderlich.android.rwdevcon"
        minSdkVersion(19)
        targetSdkVersion(27)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
    flavorDimensions("year")

    productFlavors {
        create("rwdevcon2017") {
            dimension = "year"
            applicationIdSuffix = ".y2017"
            versionNameSuffix = "-2017"
        }
        create("rwdevcon2016") {
              dimension = "year"
              applicationIdSuffix = ".y2016"
              versionNameSuffix = "-2016"
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk7", "1.3.10"))
    implementation("com.android.support:appcompat-v7:27.1.1")
    implementation("com.android.support:recyclerview-v7:27.1.1")
    implementation("com.android.support.constraint:constraint-layout:1.1.3")
    testImplementation("junit:junit:4.12")
    androidTestImplementation("com.android.support.test:runner:1.0.2")
    androidTestImplementation("com.android.support.test.espresso:espresso-core:3.0.2")
    implementation(project(":rwdevconlib"))
}