plugins {
    id(Plugins.pluginAndroidLib)
    id(Plugins.pluginKotlinAndroid)
}

android {
    namespace = AppConfigs.dataNameSpace
    compileSdk = AppConfigs.compileSdk

    defaultConfig {
        minSdk = AppConfigs.minSdk

        testInstrumentationRunner = AppConfigs.testInstrumentationRunner
        consumerProguardFiles(AppConfigs.consumerRulesPro)
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
}

dependencies {
    implementation(Deps.coreKtx)
    implementation(Deps.appcompat)
    implementation(Deps.material)
    testImplementation(Deps.testJUint)
    androidTestImplementation(Deps.androidTestJUnit)
    androidTestImplementation(Deps.androidTestExpresso)
    androidTestImplementation(Deps.testComposeUiTestJUnit4)
    implementation(Deps.testJUint)

    implementation(project(mapOf("path" to ":domain")))
    // Coroutines
    implementation(Deps.coroutines)
    implementation(Deps.coroutinesCore)
    // Retrofit & OkHttp
    implementation(Deps.retrofit)
    implementation(Deps.retrofitConverter)

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
    testImplementation(Deps.mockito)
    testImplementation(Deps.mockitoAndroid)
    testImplementation(Deps.mockitoKotlin2)
    androidTestImplementation(Deps.androidXTest)
    androidTestImplementation(Deps.espresso)
    testImplementation(Deps.mockitoInLine)
    testImplementation(Deps.mockitoKotlin)
    testImplementation(Deps.archCoreTesting)
}