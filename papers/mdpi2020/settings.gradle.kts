import de.fayard.refreshVersions.bootstrapRefreshVersions
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("de.fayard.refreshVersions:refreshVersions:0.60.3")
    }
}
bootstrapRefreshVersions()

rootProject.name = "paper20-mdpi-jsan-si-autonomy"
