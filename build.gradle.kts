// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Plugins.pluginAndroidApplication) version Versions.pluginAndroidApplication apply false
    id(Plugins.pluginKotlinAndroid) version Versions.pluginKotlinAndroid apply false
    id(Plugins.pluginHiltAndroid) version Versions.pluginHiltAndroid apply false
    id(Plugins.pluginAndroidLib) version Versions.pluginAndroidLib apply false
}