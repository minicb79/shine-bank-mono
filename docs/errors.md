# Errors in build files

## `settings.gradle.kts` in submodules is in error

Remove the `settings.gradle.kts` file from the submodules. Remember, you can only have one `settings.gradle.kts` file per project.

## An exception occurred applying plugin request id XXX

Ensure that the `java` plugin is added to the project. Do a `./gradlew clean build`. Don't rely on the IDE's gradle refresh button.

## Extension of type 'JavaPluginExtension' does not exist. Currently registered extension types: [ExtraPropertiesExtension, VersionCatalogsExtension, SpringBootExtension, StandardDependencyManagementExtension, SourceSetContainer]

Ensure that the `java` plugin is added to the project.

## Task `prepareKotlinBuildScriptModel` not found in project

Remove the module that was added manually or by the IDE (ie: not via Gradle), and rebuild using Gradle.

https://stackoverflow.com/questions/72275306/task-preparekotlinbuildscriptmodel-not-found-in-project
 