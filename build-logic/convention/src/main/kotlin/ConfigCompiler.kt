import cz.vratislavjindra.extension.android
import cz.vratislavjindra.extension.androidApplication
import cz.vratislavjindra.extension.java
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.jvm.toolchain.JavaLanguageVersion

internal class ConfigCompiler : Plugin<Project> by local plugin {

    val targetJvmVersion = JavaVersion.VERSION_21

    java {
        sourceCompatibility = targetJvmVersion
        targetCompatibility = targetJvmVersion

        toolchain {
            languageVersion.set(JavaLanguageVersion.of(targetJvmVersion.majorVersion))
        }
    }

    android {
        compileOptions {
            sourceCompatibility = targetJvmVersion
            targetCompatibility = targetJvmVersion
        }
    }

    androidApplication {
        compileOptions {
            sourceCompatibility = targetJvmVersion
            targetCompatibility = targetJvmVersion
        }
    }
}
