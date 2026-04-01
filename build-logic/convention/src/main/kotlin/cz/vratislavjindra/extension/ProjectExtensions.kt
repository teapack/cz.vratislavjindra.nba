package cz.vratislavjindra.extension

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinCommonCompilerOptions
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

internal val Project.versionCatalog: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun Project.androidApplication(block: ApplicationExtension.() -> Unit) {
    extensions.findByType<ApplicationExtension>()?.apply(block = block)
}

internal fun Project.android(block: LibraryExtension.() -> Unit) {
    extensions.findByType<LibraryExtension>()?.apply(block = block)
}

internal fun Project.java(block: JavaPluginExtension.() -> Unit) {
    extensions.findByType<JavaPluginExtension>()?.apply(block = block)
}

internal fun Project.kotlinOptions(block: KotlinCommonCompilerOptions.() -> Unit) {
    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions(configure = block)
    }
}

@Suppress("UNCHECKED_CAST")
internal fun <T> Project.typedProperty(name: String): T? = findProperty(name) as T?

fun Project.generateNamespace(): String {
    return when (name) {
        "api", "impl" -> "cz.vratislavjindra.nba.${parent!!.parent!!.name}.${parent!!.name.replace("-", ".")}.$name"
        else -> "cz.vratislavjindra.nba.${parent!!.name}.${name.replace("-", ".")}"
    }
}
