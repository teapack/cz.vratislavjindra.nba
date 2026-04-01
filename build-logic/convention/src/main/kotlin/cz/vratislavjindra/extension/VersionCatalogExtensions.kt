package cz.vratislavjindra.extension

import org.gradle.api.artifacts.VersionCatalog

internal fun VersionCatalog.bundle(alias: String) = findBundle(alias).get()

internal fun VersionCatalog.library(alias: String) = findLibrary(alias).get()

internal fun VersionCatalog.plugin(alias: String) = findPlugin(alias).get()

internal fun VersionCatalog.version(alias: String) = findVersion(alias).get().toString()
