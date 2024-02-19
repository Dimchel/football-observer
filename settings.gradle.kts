pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Football Observer"

include(":app")
include(":core:common")
include(":core:navigation")
include(":core:network")
include(":core:ui")
include(":feature:competitions")
include(":feature:league")
