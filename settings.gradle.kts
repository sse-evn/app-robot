pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
        repositories {
            google()
            mavenCentral()
            maven { url = uri("https://maven.yandex.ru") }
        }
}

rootProject.name = "My Application"
include(":app")
 