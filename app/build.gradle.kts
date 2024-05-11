plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.23"
    id("kotlin-kapt")
}

android {
    namespace = "no.uio.ifi.in2000.team_21"
    compileSdk = 34

    defaultConfig {
        applicationId = "no.uio.ifi.in2000.team_21"
        minSdk = 26
        targetSdk = 34
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
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}



dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("com.google.firebase:firebase-crashlytics-buildtools:2.9.9") // Denne burde være 21.2.0 sammed med 'play-services-location', mend de deler ikke samme versjon???
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2024.02.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation ("org.osmdroid:osmdroid-android:6.1.14")
    implementation ("org.slf4j:slf4j-simple:1.7.30")
    implementation ("androidx.compose.material:material:1.6.4")
    implementation("org.osmdroid:osmdroid-android:6.1.14")
    implementation("androidx.activity:activity:1.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Ktor 8)
    implementation("org.jetbrains.kotlin:kotlin-serialization:1.9.23")
    implementation("io.ktor:ktor-serialization-gson:2.3.8")
    implementation("io.ktor:ktor-client-core:2.3.8")
    implementation("io.ktor:ktor-client-cio:2.3.8")
    implementation("io.ktor:ktor-client-content-negotiation:2.3.8")
    implementation("io.ktor:ktor-client-serialization:2.3.8")
    implementation("io.ktor:ktor-client-core-jvm:2.3.8")
    implementation("io.ktor:ktor-client-cio-jvm:2.3.8")
    implementation ("io.ktor:ktor-client-content-negotiation-jvm:2.3.8")

    implementation ("io.ktor:ktor-serialization-kotlinx-json-jvm:2.3.8")
    implementation("io.ktor:ktor-client-logging:2.3.8")
    implementation ("io.ktor:ktor-serialization-kotlinx-json-jvm:2.3.8")
    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")
    implementation("io.ktor:ktor-serialization-gson:$2.3.8")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
    implementation("io.coil-kt:coil-compose:2.5.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")

    // Jetpack Compose 8)
    implementation("androidx.compose.material3:material3-android:1.2.1")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.ui:ui:1.6.4")
    implementation("androidx.compose.material:material:1.6.4")
    implementation("androidx.compose.ui:ui-tooling:1.6.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.runtime:runtime-livedata:1.6.4")
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.4")


    // Navigate app
    val nav_version = "2.7.6"
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation("io.ktor:ktor-client-logging:2.3.8")

    implementation("com.github.MKergall:osmbonuspack:6.9.0")

    // Gson og sånn
    implementation("io.ktor:ktor-client-core:2.3.10") // Use the latest version
    implementation("io.ktor:ktor-client-cio:2.3.10")
    implementation("io.ktor:ktor-client-json:2.3.10")
    implementation("io.ktor:ktor-client-serialization-jvm:2.3.10")
    implementation("com.google.code.gson:gson:2.10.1") // Gson library


    // Location
    implementation("com.google.android.gms:play-services-location:20.0.0") // DENNE MÅ VÆRE 20.0.0 TIL TROSS FOR NYERE VERSJONER!!!!
    implementation("com.google.accompanist:accompanist-permissions:0.34.0")

    // Room (SQLite) for database
    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    // Mapbox
    implementation("com.mapbox.maps:android:11.3.0")
    implementation("com.mapbox.extension:maps-compose:11.3.0")
    /*implementation("com.mapbox.search:autofill:1.2.0")
    implementation("com.mapbox.search:discover:1.2.0")
    implementation("com.mapbox.search:place-autocomplete:1.2.0")
    implementation("com.mapbox.search:offline:1.2.0")
    implementation("com.mapbox.search:mapbox-search-android:1.2.0")*/
}


apply(plugin = "org.jetbrains.kotlin.plugin.serialization")