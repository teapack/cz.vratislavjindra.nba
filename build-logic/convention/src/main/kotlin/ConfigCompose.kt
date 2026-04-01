import cz.vratislavjindra.extension.android
import cz.vratislavjindra.extension.androidApplication
import cz.vratislavjindra.extension.androidTestImplementation
import cz.vratislavjindra.extension.api
import cz.vratislavjindra.extension.debugImplementation
import cz.vratislavjindra.extension.implementation
import cz.vratislavjindra.extension.library
import cz.vratislavjindra.extension.plugin
import cz.vratislavjindra.extension.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

internal class ConfigCompose: Plugin<Project> by local plugin {

    pluginManager.apply {
        apply(
            plugin = versionCatalog.plugin(alias = "kotlin-compose").get().pluginId,
        )
    }

    android {
        buildFeatures {
            compose = true
        }
    }

    androidApplication {
        buildFeatures {
            compose = true
        }
    }

    dependencies {
        val composeBom = platform(
            versionCatalog.library(alias = "androidx-compose-bom"),
        )
        api(provider = composeBom)
        api(provider = versionCatalog.library(alias = "androidx-compose-material3"))
        api(provider = versionCatalog.library(alias = "androidx-compose-material-icons-core"))
        api(provider = versionCatalog.library(alias = "androidx-compose-material-icons-extended"))

        implementation(provider = versionCatalog.library(alias = "coil-compose"))
        implementation(provider = versionCatalog.library(alias = "kotlinx-collections-immutable"))

        debugImplementation(provider = versionCatalog.library(alias = "androidx-compose-ui-test-manifest"))
        debugImplementation(provider = versionCatalog.library(alias = "androidx-compose-ui-tooling-preview"))

        androidTestImplementation(provider = composeBom)
        androidTestImplementation(provider = versionCatalog.library(alias = "androidx-compose-ui-test-junit4"))
    }
}
