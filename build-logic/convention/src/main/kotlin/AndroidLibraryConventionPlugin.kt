import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

internal class AndroidLibraryConventionPlugin : Plugin<Project> by local plugin {

    apply<ConfigAndroidLibrary>()

    apply<ConfigAndroidBuild>()
    apply<ConfigCompiler>()
    apply<ConfigCompose>()
}
