
plugins {
    id("com.android.application")
    id ("kotlin-android")
    id("org.jetbrains.kotlin.android")
    id ("com.google.gms.google-services")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.enchipai"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.enchipai"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.appcompat:appcompat:1.4.2")
    implementation ("com.google.android.material:material:1.6.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

    implementation (platform("com.google.firebase:firebase-bom:30.3.1"))
    implementation ("com.google.firebase:firebase-auth-ktx")

    implementation ("androidx.activity:activity-compose:1.5.1")
    implementation ("androidx.compose.material3:material3:1.0.0-beta01")
    implementation ("androidx.compose.animation:animation:1.2.1")
    implementation ("androidx.compose.ui:ui-tooling:1.2.1")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    implementation ("androidx.navigation:navigation-compose:2.5.1")
    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    implementation ("com.google.dagger:hilt-android:2.42")
    implementation ("com.google.firebase:firebase-database-ktx:20.2.2")
    implementation("com.android.support:support-annotations:28.0.0")
    implementation("com.google.firebase:firebase-ml-modeldownloader-ktx:24.1.3")
    implementation("com.google.android.datatransport:transport-runtime:3.1.9")
    implementation("com.google.firebase:firebase-functions-ktx:20.3.1")
    kapt ("com.google.dagger:hilt-android-compiler:2.42")

    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.2.1")

}

kapt {
    correctErrorTypes = true
}
