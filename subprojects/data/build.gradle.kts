plugins {
    java
    kotlin("jvm") version embeddedKotlinVersion
    kotlin("plugin.serialization") version embeddedKotlinVersion
}

dependencies {
    implementation(embeddedKotlin("stdlib-jdk8"))
    implementation(Dependencies.ktor)
    implementation(Dependencies.ktorJson)
    implementation(Dependencies.ktorSerialization)
    implementation(Dependencies.coroutines)
    implementation(Dependencies.serialization)
    implementation(project(Dependencies.SubProjects.domain))

    testImplementation(kotlin("test-junit"))
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}
