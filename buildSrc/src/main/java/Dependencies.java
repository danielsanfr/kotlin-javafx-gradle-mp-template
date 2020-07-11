final class Dependencies {
    public static final String ktor = "io.ktor:ktor-client-okhttp:" + Versions.ktor;
    public static final String ktorJson = "io.ktor:ktor-client-json-jvm:" + Versions.ktor;
    public static final String ktorSerialization = "io.ktor:ktor-client-serialization-jvm:" + Versions.ktor;
    public static final String serialization = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:" + Versions.serialization;
    public static final String coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:" + Versions.coroutines;

    private Dependencies() { /* Empty body */ }

    public static final class SubProjects {
        public static final String presentation = ":subprojects:presentation";
        public static final String domain = ":subprojects:domain";
        public static final String data = ":subprojects:data";

        private SubProjects() { /* Empty body */ }
    }
}
