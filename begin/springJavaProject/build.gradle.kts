plugins {
    java
    id("org.springframework.boot") version "2.5.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    jacoco
    id("com.bmuschko.docker-spring-boot-application") version "7.1.0"
    id("com.avast.gradle.docker-compose") version "0.13.4"
}

group = "com.tinkoff.sirius"
version = "0.0.1-SNAPSHOT"


java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-ui:1.5.2")
    implementation("org.liquibase:liquibase-core")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.mockito:mockito-core:+")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.batch:spring-batch-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

dependencyManagement {
    imports {
        mavenBom("org.testcontainers:testcontainers-bom:1.15.3")
    }
}

tasks {
    test {
        useJUnitPlatform()
    }

}



dockerCompose {
    useComposeFiles = listOf("docker-compose.application.yml")

    dockerComposeWorkingDirectory = "docker"

    composeLogToFile = project.file("build/docker-compose/containers-logs.txt")
    captureContainersOutputToFiles = project.file("build/docker-compose/containers-output/")

    projectName = project.name

    isRequiredBy(tasks.test)
}