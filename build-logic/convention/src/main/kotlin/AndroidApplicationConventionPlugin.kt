import cz.vratislavjindra.extension.implementation
import cz.vratislavjindra.extension.ksp
import cz.vratislavjindra.extension.library
import cz.vratislavjindra.extension.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

internal class AndroidApplicationConventionPlugin : Plugin<Project> by local plugin {

    apply<ConfigAndroidApplication>()

    apply<ConfigAndroidBuild>()
    apply<ConfigAndroidLint>()
    apply<ConfigAndroidVersioning>()
    apply<ConfigCompiler>()

    dependencies {

        implementation(provider = versionCatalog.library(alias = "androidx-activity-compose"))
        implementation(provider = versionCatalog.library(alias = "androidx-core-ktx"))
        implementation(provider = versionCatalog.library(alias = "androidx-lifecycle-runtime-ktx"))
        implementation(provider = versionCatalog.library(alias = "hilt-android"))

        ksp(provider = versionCatalog.library(alias = "hilt-compiler"))
    }
}
