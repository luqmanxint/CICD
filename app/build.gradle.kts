import io.gitlab.arturbosch.detekt.Detekt
import org.jetbrains.kotlin.js.backend.ast.JsEmpty.setSource

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("org.jlleitschuh.gradle.ktlint") version "11.0.0"
    id("io.gitlab.arturbosch.detekt") version "1.22.0"
}

android {
    namespace = "com.myfirstcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.myfirstcompose"
        minSdk = 24
        //noinspection EditedTargetSdkVersion
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {

        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        create("benchmark") {
            initWith(buildTypes.getByName("release"))
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            isDebuggable = false
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig= true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}
//tasks.getByPath("preBuild").dependsOn("ktlintFormat")
//ktlint {
//    enableExperimentalRules.set(true)
//
//    android.set(true)
//    ignoreFailures.set(false)
//    debug.set(true)
//    verbose.set(true)
//    outputToConsole.set(true)
//    outputColorName.set("RED")
//
//    filter {
//        include("**/**.kt", "**/**.kts")
//        exclude("**/build/**")
//    }
//    disabledRules.add("no-wildcard-imports")
//    disabledRules.add("no-consecutive-blank-lines")
//    disabledRules.add("no-blank-line-before-rbrace")
//    disabledRules.add("indent")
//    disabledRules.add("no-blank-line-before-rbrace")
//    disabledRules.add("final-newline")
//    disabledRules.add("import-ordering")
//    disabledRules.add("comment-spacing")
//
//
//    reporters {
//        reporter(reporterType = org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
//        reporter(reporterType = org.jlleitschuh.gradle.ktlint.reporter.ReporterType.CHECKSTYLE)
//        reporter(reporterType = org.jlleitschuh.gradle.ktlint.reporter.ReporterType.SARIF)
//    }
//}
//
//tasks.withType<Detekt>().configureEach {
//    // Common configuration for all Detekt tasks
////    config.setFrom(files("path/to/detekt-config.yml"))
//    include("**/*.kt", "**/*.kts")
//    exclude("**/build/**")
//    jvmTarget = JavaVersion.VERSION_17.toString()
//    reports {
//        txt.required.set(false)
//        sarif.required.set(false)
//        md.required.set(false)
//        xml.required.set(false)
//        html.required.set(true)
//        html.outputLocation.set(file("${project.buildDir}/reports/detekt/detekt.html"))
//    }
//}
//
//detekt {
//    parallel = true
//    allRules = true
//    autoCorrect = true
//    buildUponDefaultConfig = true
//    setSource(file(projectDir))
//    config.setFrom(file("${rootProject.rootDir}/config/detekt/detekt.yml"))
//}


dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")


    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation(platform("com.google.firebase:firebase-bom:32.7.1"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.squareup.okhttp3:okhttp:4.9.1")


//    debuging tools
    implementation("com.jakewharton.timber:timber:5.0.1")
    implementation("com.facebook.stetho:stetho:1.6.0")
    implementation ("com.facebook.stetho:stetho-okhttp3:1.6.0")


    debugImplementation("com.github.chuckerteam.chucker:library:4.0.0")
    releaseImplementation("com.github.chuckerteam.chucker:library-no-op:4.0.0")


//    for MemoryLeaks
    debugImplementation ("com.squareup.leakcanary:leakcanary-android:3.0-alpha-1")
    androidTestImplementation ("com.squareup.leakcanary:leakcanary-android-instrumentation:3.0-alpha-1")

//    for BenchMark

        implementation ("androidx.profileinstaller:profileinstaller:1.3.1")


//    Unit Testing

    /* JUnit*/
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")

//    Kluent
    testImplementation ("org.amshove.kluent:kluent:1.65")
    testImplementation ("org.amshove.kluent:kluent-android:1.65")
    testImplementation ("org.jetbrains.kotlin:kotlin-test-junit:1.5.31")

//    Mokk
    testImplementation ("io.mockk:mockk:1.12.0")

//    ANdroid Testing

//    Roboelectric
    testImplementation ("org.robolectric:robolectric:4.11.1")
    testImplementation ("org.robolectric:annotations:4.11.1")

}
