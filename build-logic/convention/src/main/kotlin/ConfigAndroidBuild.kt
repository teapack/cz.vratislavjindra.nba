import cz.vratislavjindra.extension.android
import cz.vratislavjindra.extension.androidApplication
import cz.vratislavjindra.extension.generateNamespace
import cz.vratislavjindra.extension.version
import cz.vratislavjindra.extension.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class ConfigAndroidBuild : Plugin<Project> by local plugin {

    android {
        compileSdk = versionCatalog.version(alias = "android-compile-sdk").toInt()

        defaultConfig {
            minSdk = versionCatalog.version(alias = "android-min-sdk").toInt()
        }

        namespace = generateNamespace()
    }

    androidApplication {
        compileSdk = versionCatalog.version(alias = "android-compile-sdk").toInt()

        defaultConfig {
            minSdk = versionCatalog.version(alias = "android-min-sdk").toInt()
            targetSdk = versionCatalog.version(alias = "android-target-sdk").toInt()
        }
    }
}
