plugins {
    java
    kotlin("jvm") version embeddedKotlinVersion
}

dependencies {
    implementation(embeddedKotlin("stdlib-jdk8"))
    implementation(Dependencies.coroutines)
    implementation(project(Dependencies.SubProjects.domain))
    implementation(project(Dependencies.SubProjects.data))

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
