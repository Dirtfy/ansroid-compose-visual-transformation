plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)

    `maven-publish`
}

android {
    namespace = "com.dirtfy.visualtransformation"
    compileSdk = 35

    defaultConfig {
        aarMetadata {
            minCompileSdk = 21
        }

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
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        compose = true
    }

    composeCompiler {
        reportsDestination = layout.buildDirectory.dir("compose_compiler")
        stabilityConfigurationFile =
            rootProject.layout.projectDirectory.file("stability_config.conf")
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    androidTestImplementation(composeBom)

    implementation(libs.androidx.ui)

}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                groupId = "com.github.Dirtfy"

                afterEvaluate {
                    from(components["release"])
                }
            }
        }
    }
}
