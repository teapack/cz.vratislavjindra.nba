import cz.vratislavjindra.extension.android
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class ConfigAndroidLint : Plugin<Project> by local plugin {

    android {
        lint {
            checkDependencies = true
            ignoreTestSources = true
            xmlReport = false
        }
    }
}
