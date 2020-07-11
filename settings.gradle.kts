rootProject.name = "KotlinJavaFXGradleMultiprojects"
rootProject.buildFileName = "build.gradle.kts"

include("app")
include("subprojects:data")
include("subprojects:domain")
include("subprojects:presentation")
