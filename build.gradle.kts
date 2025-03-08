plugins {
    id("java")
    `maven-publish`
}

group = "dev.imanity.antixray"
version = "1.0.3"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.16.4-R0.1-SNAPSHOT")
}

tasks.test {
    useJUnitPlatform()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            groupId = "dev.imanity.antixray"
            artifactId = "antixray-sdk"
            version = project.version.toString()
        }
    }

    repositories {
        maven {
            url = uri("https://repo.imanity.dev/imanity-libraries")
            credentials {
                username = findProperty("imanityLibrariesUsername").toString()
                password = findProperty("imanityLibrariesPassword").toString()
            }
        }
    }
}
