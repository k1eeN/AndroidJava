plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.androidjava"
    compileSdk {
        version = release(36)
    }

    flavorDimensions += "lesson"

    productFlavors {
        create("lesson3") {
            dimension = "lesson"
            applicationIdSuffix = ".lesson3"
            resValue("string", "app_name", "AndroidJava Lesson3")
        }
        create("lesson4") {
            dimension = "lesson"
            applicationIdSuffix = ".lesson4"
            resValue("string", "app_name", "AndroidJava Lesson4")
        }
        create("lesson5") {
            dimension = "lesson"
            applicationIdSuffix = ".lesson5"
            resValue("string", "app_name", "AndroidJava Lesson5")
        }
    }

    defaultConfig {
        applicationId = "com.example.androidjava"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}