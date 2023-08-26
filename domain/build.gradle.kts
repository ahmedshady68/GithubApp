plugins {
    id(Plugins.pluginAndroidLib)
    id(Plugins.pluginKotlinAndroid)
}

android {
    namespace = AppConfigs.domainNameSpace
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
    implementation(Deps.gson)
}