rootProject.name = "shiny-bank"

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
    }
    // includeBuild("../my-build-logic")
}

plugins {
    // apply settings plugins to share configuration among several builds
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
    // includeBuild("../my-other-project")
}

//include("app")
//include("business-logic")
//include("data-model")

include("monolith:mono-bank")

rootDir.listFiles().filter {
    it.isDirectory && !it.isHidden
}.filterNot {
    it.name in listOf("docs", "gradle")
}.forEach {
    include(it.name)
}