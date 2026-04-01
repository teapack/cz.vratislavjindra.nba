import cz.vratislavjindra.extension.androidApplication
import cz.vratislavjindra.extension.version
import cz.vratislavjindra.extension.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class ConfigAndroidVersioning : Plugin<Project> by local plugin {

    androidApplication {
        val name = versionCatalog.version(alias = "app-version-name")
        val code = versionCatalog.version(alias = "app-version-code").toInt()
        val nameSuffix = "-$code"

        defaultConfig {
            versionCode = code
            versionName = name
        }

        buildTypes {
            getByName("debug") {
                versionNameSuffix = nameSuffix
            }
            create("staging") {
                versionNameSuffix = nameSuffix
            }
            getByName("release") {
                versionNameSuffix = null
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile(name = "proguard-android-optimize.txt"),
                    "proguard-rules.pro",
                )
            }
        }
    }
}
