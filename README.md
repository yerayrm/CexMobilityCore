## Pasos para añadir el módulo a un proyecto

1. Para añadir el módulo al proyecto.

`git submodule add git@gitlab.com:cex-utilities/android/androidiecimodule.git`

2. Añadir el modulo al settings.gradle

`include ':app', ':androidiecimodule'`

3. Importar el modulo en el fichero gradle de la app 'build.gradle'

`implementation project(path: ':androidiecimodule')`
