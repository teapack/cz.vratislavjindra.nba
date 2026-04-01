import cz.vratislavjindra.extension.plugin
import cz.vratislavjindra.extension.versionCatalog
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

internal class ConfigAndroidLibrary : Plugin<Project> by local plugin {

    pluginManager.apply {
        apply(
            plugin = versionCatalog.plugin(alias = "android-library").get().pluginId,
        )
    }
}
