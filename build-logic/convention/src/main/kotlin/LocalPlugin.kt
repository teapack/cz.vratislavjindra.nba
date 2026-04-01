import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("ClassName")
internal object local

internal infix fun local.plugin(config: Project.() -> Unit) = Plugin<Project> { project ->
    config(project)
}
