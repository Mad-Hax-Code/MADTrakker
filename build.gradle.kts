import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("plugin.jpa") version "1.2.71"
    id("org.springframework.boot") version "2.1.5.RELEASE"
    id("io.spring.dependency-management") version "0.6.0.RELEASE"
    kotlin("jvm") version "1.2.71"
    kotlin("plugin.spring") version "1.2.71"
}

group = "com.madhax"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()

    maven {
        url = uri("http://repo.spring.io/milestone")
    }
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // All implementation R2DBC stuff here:
    implementation("org.springframework.data:spring-data-r2dbc:1.0.0.M2")
    implementation("org.springframework.boot.experimental:spring-boot-starter-r2dbc-h2")
    implementation("io.projectreactor:reactor-core")
    implementation("io.r2dbc:r2dbc-spi:1.0.0.M7")

    runtimeOnly("org.springframework.boot:spring-boot-devtools")
//    runtimeOnly("com.h2database:h2")

    // All runtime R2DBC stuff here:
    runtimeOnly("io.r2dbc:r2dbc-h2")
    runtimeOnly("io.r2dbc:r2dbc-postgresql:1.0.0.M6")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")

    // All testImplementation R2DBC stuff:
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}
