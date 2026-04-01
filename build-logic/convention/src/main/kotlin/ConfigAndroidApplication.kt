import cz.vratislavjindra.extension.androidApplication
import cz.vratislavjindra.extension.plugin
import cz.vratislavjindra.extension.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

internal class ConfigAndroidApplication : Plugin<Project> by local plugin {

    pluginManager.apply {
        apply(
            plugin = versionCatalog.plugin(alias = "android-application").get().pluginId,
        )
        apply(
            plugin = versionCatalog.plugin(alias = "kotlin-compose").get().pluginId,
        )
        apply(
            plugin = versionCatalog.plugin(alias = "ksp").get().pluginId,
        )
        apply(
            plugin = versionCatalog.plugin(alias = "hilt-android").get().pluginId,
        )
    }

    androidApplication {

        namespace = "cz.vratislavjindra.nba"

        defaultConfig {
            applicationId = "cz.vratislavjindra.nba"
        }
    }
}
