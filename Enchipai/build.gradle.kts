buildscript {
    dependencies {
        classpath ("com.google.gms:google-services:4.3.3")
        classpath ("com.android.tools.build:gradle:7.2.2")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.42")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "7.2.1" apply false
    id ("com.android.library") version "7.2.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.7.10" apply false
    id ("com.google.dagger.hilt.android") version "2.42" apply false
}
