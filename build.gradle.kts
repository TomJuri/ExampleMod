plugins {
    kotlin("jvm") version "1.9.23"
    id("com.github.TomJuri.NebulaGradle") version "-SNAPSHOT"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("net.kyori.blossom") version "1.3.1"
}

group = "de.tomjuri"
version = "1.0.0"

val embedImpl: Configuration by configurations.creating
configurations.implementation.get().extendsFrom(embedImpl)

val embedCompile: Configuration by configurations.creating
configurations.compileOnly.get().extendsFrom(embedCompile)

dependencies {
    embedCompile("org.spongepowered:mixin:0.8.5-SNAPSHOT")
}

blossom {
    replaceToken("%%VERSION%%", version)
}

nebulagradle {
    launchConfig {
        javaExecutable = "YOUR_JAVA_8_PATH"
        cliArg = "--mixin mixins.examplemod.json"
    }
    mixin {
        name = "examplemod"
    }
}

tasks {
    jar {
        manifest.attributes(
                mapOf(
                        "ModSide" to "CLIENT",
                        "TweakOrder" to "0",
                        "ForceLoadAsMod" to true,
                        "MixinConfigs" to "mixins.examplemod.json"
                )
        )
        dependsOn(shadowJar)
    }

    remapMod {
        input.set(shadowJar.get().archiveFile)
    }

    shadowJar {
        isEnableRelocation = true
        relocationPrefix = "de.tomjuri.examplemod.relocate"
        configurations = listOf(embedImpl, embedCompile)
    }

    processResources {
        inputs.property("version", version)
        filesMatching(listOf("mcmod.info")) {
            expand(mapOf("version" to version))
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

java.toolchain.languageVersion = JavaLanguageVersion.of(8)
kotlin.jvmToolchain(8)