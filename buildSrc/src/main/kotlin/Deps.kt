object Deps {
    val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBomCommon}" }

    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
    val appcompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val material by lazy { "com.google.android.material:material:${Versions.material}" }
    val gson by lazy { "com.google.code.gson:gson:${Versions.gson}" }

    val composeMaterial by lazy { "androidx.compose.material:material:${Versions.composeMaterial}" }
    val activityCompose by lazy { "androidx.activity:activity-compose:${Versions.activityCompose}" }
    val constraintLayoutCompose by lazy { "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayoutCompose}" }
    val lifecycRuntimeKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleCommon}" }
    val lifecycleViewModelCompose by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycleCommon}" }
    val lifecycleViewModelKtx by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleCommon}" }
    val lifecycleRuntimeCompose by lazy { "androidx.lifecycle:lifecycle-runtime-compose:${Versions.lifecycleCommon}" }

    val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Versions.hiltAndroid}" }
    val hiltAndroidCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltAndroidCompiler}" }
    val hiltAndroidNav by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltAndroidNav}" }

    val mediaExoPlayer by lazy { "androidx.media3:media3-exoplayer:${Versions.mediaExoPlayer}" }

    val glideCompose by lazy { "com.github.bumptech.glide:compose:${Versions.glideCompose}" }

    val lottieCompose by lazy { "com.airbnb.android:lottie-compose:${Versions.lottieCompose}" }

    val testJUint by lazy { "junit:junit:${Versions.testJUnit}" }
    val androidTestJUnit by lazy { "androidx.test.ext:junit:${Versions.androidTestJUnit}" }
    val androidTestExpresso by lazy { "androidx.test.espresso:espresso-core:${Versions.androidTestEspresso}" }

    val composeUI by lazy { "androidx.compose.ui:ui" }
    val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics" }
    val composeUiToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
    val composeMaterial3 by lazy { "androidx.compose.material3:material3" }

    val testComposeUiTestJUnit4 by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.androidTestJUnit4}" }

    val debugComposeUiTooling by lazy { "androidx.compose.ui:ui-tooling" }
    val debugComposeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest" }
    // retrofit
    val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val retrofitConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofitConverter}" }
    val retrofitSerialization by lazy { "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Versions.retrofitSerialization}" }
    val coil by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }
    val mockk by lazy { "io.mockk:mockk:${Versions.mockk}" }
    val coroutinesTest by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesTest}" }
    val coreTest by lazy { "androidx.arch.core:core-testing:${Versions.coreTest}" }
    // coroutines
    val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}" }
    val coroutinesCore by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}" }

}