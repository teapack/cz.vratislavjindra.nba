package cz.vratislavjindra.extension

import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope

internal fun DependencyHandlerScope.api(provider: Provider<*>) = addProvider(
    configurationName = "api",
    dependencyNotation = provider,
)

internal fun DependencyHandlerScope.implementation(provider: Provider<*>) = addProvider(
    configurationName = "implementation",
    dependencyNotation = provider,
)

internal fun DependencyHandlerScope.ksp(provider: Provider<*>) = addProvider(
    configurationName = "ksp",
    dependencyNotation = provider,
)

internal fun DependencyHandlerScope.androidTestImplementation(provider: Provider<*>) = addProvider(
    configurationName = "androidTestImplementation",
    dependencyNotation = provider,
)

internal fun DependencyHandlerScope.debugImplementation(provider: Provider<*>) = addProvider(
    configurationName = "debugImplementation",
    dependencyNotation = provider,
)
