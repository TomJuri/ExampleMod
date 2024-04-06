pluginManagement {
    resolutionStrategy {
        eachPlugin {
            if(requested.id.toString() == "com.github.TomJuri.NebulaGradle")
                useModule("com.github.TomJuri:NebulaGradle:-SNAPSHOT")
        }
    }
    repositories {
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

rootProject.name = "ExampleMod"