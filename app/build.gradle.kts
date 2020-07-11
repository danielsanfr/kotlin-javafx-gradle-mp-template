plugins {
    application
    kotlin("jvm") version embeddedKotlinVersion
    id("org.openjfx.javafxplugin") version "0.0.8"
}

application.mainClassName = "br.com.danielsan.app.MainKt"

dependencies {
    implementation(project(Dependencies.SubProjects.presentation))
    implementation(project(Dependencies.SubProjects.domain))
    implementation(project(Dependencies.SubProjects.data))

    implementation(embeddedKotlin("stdlib-jdk8"))
    implementation(Dependencies.coroutines)
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:${Versions.coroutines}")

    implementation("com.dlsc.formsfx:formsfx-core:11.4.1")

    implementation("org.kordamp.ikonli:ikonli-javafx:11.5.0")

    implementation("org.controlsfx:controlsfx:8.40.16")

    testImplementation(kotlin("test-junit"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

javafx {
    version = "14"
    modules = listOf("javafx.graphics", "javafx.controls", "javafx.fxml")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
