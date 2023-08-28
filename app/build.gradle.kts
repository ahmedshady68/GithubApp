plugins {
    id(Plugins.pluginAndroidApplication)
    id(Plugins.pluginKotlinAndroid)
    kotlin(Plugins.pluginKapt)
    id(Plugins.pluginHiltAndroid)
}

android {
    namespace = AppConfigs.appNameSpace
    compileSdk = AppConfigs.compileSdk

    defaultConfig {
        applicationId = AppConfigs.applicationId
        minSdk = AppConfigs.minSdk
        targetSdk = AppConfigs.targetSdk
        versionCode = AppConfigs.versionCode
        versionName = AppConfigs.versionName

        testInstrumentationRunner = AppConfigs.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            isShrinkResources = false
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile(Constants.PROGUARD_ANDROID_OPTIMIZE),
                Constants.PROGUARD_RULES
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfigs.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += Constants.EXCLUDES
        }
    }
}

dependencies {
    implementation(Deps.coreKtx)
    // Jetpack Compose and related libraries
    implementation(platform(Deps.composeBom))
    androidTestImplementation(Deps.composeBom)
    implementation(Deps.composeUI)
    implementation(Deps.composeUiGraphics)
    implementation(Deps.composeUiToolingPreview)
    implementation(Deps.composeMaterial3)
    implementation(Deps.composeMaterial)
    implementation(Deps.activityCompose)
    implementation(Deps.constraintLayoutCompose)
    implementation(Deps.lifecycRuntimeKtx)
    implementation(Deps.lifecycleViewModelCompose)
    implementation(Deps.lifecycleViewModelKtx)
    implementation(Deps.lifecycleRuntimeCompose)
    implementation(Deps.testJUint)
    // Dagger Hilt for Dependency Injection
    implementation(Deps.hiltAndroid)
    implementation(Deps.hiltAndroidNav)
    kapt(Deps.hiltAndroidCompiler)
    // Retrofit
    implementation(Deps.retrofit)
    implementation(Deps.retrofitConverter)
    implementation(Deps.retrofitSerialization)
    implementation(Deps.lottieCompose)
    // test
    androidTestImplementation(Deps.androidTestJUnit)
    androidTestImplementation(Deps.androidTestExpresso)
    androidTestImplementation(Deps.testComposeUiTestJUnit4)
    androidTestImplementation(Deps.debugComposeUiTooling)
    androidTestImplementation(Deps.debugComposeUiTestManifest)
    implementation(Deps.coil)
    testImplementation(Deps.mockk)
    testImplementation(Deps.coroutinesTest)
    testImplementation(Deps.coreTest)

    //test
    androidTestImplementation(Deps.androidXTest)
    androidTestImplementation(Deps.espresso)
    testImplementation(Deps.archCoreTesting)
    testImplementation(Deps.coroutinesTest)
    // Coroutines
    implementation(Deps.coroutines)
    implementation(Deps.coroutinesCore)
    implementation(project(mapOf("path" to ":domain")))
    implementation(project(mapOf("path" to ":data")))
}
// Allow references to generated code
kapt {
    correctErrorTypes = true
}
