plugins {
    id("java")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

group = "org.dommorabito"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks {
    withType<JavaCompile> {
        options.compilerArgs.add("--enable-preview")
    }
    withType<JavaExec> {
        jvmArgs("--enable-preview")
    }
    withType<Test> {
        useJUnitPlatform()
        jvmArgs("--enable-preview")
    }
}