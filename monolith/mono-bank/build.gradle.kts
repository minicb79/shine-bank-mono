import org.jetbrains.kotlin.cli.jvm.compiler.writeOutput
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	java
	id("org.springframework.boot") version "3.2.0"
	id("io.spring.dependency-management") version "1.1.4"
	id("org.hibernate.orm") version "6.4.1.Final"
	id("org.graalvm.buildtools.native") version "0.9.28"
	kotlin("jvm") version "1.9.20"
	kotlin("plugin.spring") version "1.9.20"
	kotlin("plugin.jpa") version "1.9.20"
}

group = "com.shine.bank"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testRuntimeOnly("com.h2database:h2")
	runtimeOnly("org.postgresql:postgresql:42.7.1")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

testing {
	suites {
		val test by getting(JvmTestSuite::class) {
			useJUnitJupiter()
		}

		val testIntegration by registering(JvmTestSuite::class) {
			dependencies {
				implementation(project())
				implementation("org.springframework.boot:spring-boot-starter-test")
			}

			testType.set(TestSuiteType.INTEGRATION_TEST)

			targets {
				all {
					testTask.configure {
						shouldRunAfter(test)
					}
				}
			}
		}
	}
}

val testIntegrationImplementation: Configuration by configurations.getting {
	extendsFrom(configurations.testImplementation.get())
	extendsFrom(configurations.testRuntimeClasspath.get())
}

hibernate {
	enhancement {
		enableAssociationManagement.set(true)
	}
}

