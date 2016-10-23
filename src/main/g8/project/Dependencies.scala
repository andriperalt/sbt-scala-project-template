import sbt._

/**
 * Maneja las dependencias de la aplicación.
 */
object Dependencies {

  /**
   * Define exclusiones necesarias en las librerías para evitar conflictos.
   *
   * Hay dos tipos:
   * - Exclusions: que son paquetes de exclusiones usado por solo una librería.
   * - Exclude: que una sola exclusión especifica que puede ser usada por una o varias librerías.
   *
   * Orden:
   * - Primero Exclusions luego Exclude.
   * - Alfabético entre Exclusions.
   * - Por composición entre Exclude.
   */
  private[Dependencies] implicit class Exclude(module: ModuleID) {

    def scalaLoggingExclude: ModuleID = module.logScalaExclude.exclude("com.typesafe.scala-logging", "scala-logging_2.11")

    def logScalaExclude: ModuleID = module.logsExclude.scalaLibraryExclude

    def logsExclude: ModuleID = module.logbackExclude.scalaLoggingOldLibsExclude.log4jExclude

    def logbackExclude: ModuleID = {
      module.excludeAll(
        ExclusionRule("ch.qos.logback", "logback-classic"),
        ExclusionRule("ch.qos.logback", "logback-core")
      )
    }

    /**
     * @see https://stackoverflow.com/questions/29065603/complete-scala-logging-example
     */
    def scalaLoggingOldLibsExclude: ModuleID = {
      module.excludeAll(
        ExclusionRule("com.typesafe.scala-logging", "scala-logging-api_2.11"),
        ExclusionRule("com.typesafe.scala-logging", "scala-logging-slf4j_2.11")
      )
    }

    /**
     * @see http://www.slf4j.org/legacy.html
     */
    def log4jExclude: ModuleID = {
      module.excludeAll(
        ExclusionRule("commons-logging", "commons-logging"),
        ExclusionRule("log4j"          , "log4j"),
        ExclusionRule("org.slf4j"      , "jcl-over-slf4j"),
        ExclusionRule("org.slf4j"      , "jul-to-slf4j"),
        ExclusionRule("org.slf4j"      , "log4j-over-slf4j"),
        ExclusionRule("org.slf4j"      , "slf4j-api"),
        ExclusionRule("org.slf4j"      , "slf4j-jcl"),
        ExclusionRule("org.slf4j"      , "slf4j-jdk14"),
        ExclusionRule("org.slf4j"      , "slf4j-log4j12"),
        ExclusionRule("org.slf4j"      , "slf4j-nop"),
        ExclusionRule("org.slf4j"      , "slf4j-simple")
      )
    }

    def scalaLibraryExclude: ModuleID = module.exclude("org.scala-lang", "scala-library")
  }

  /**
   * Define las librerías necesarias para compilar.
   *
   * Orden por importancia y prioridad, primero cosas como scala, akka y finalmente utilidades y log.
   */
  private[Dependencies] object CompileDep {

    import Versions._

    val `scala-compiler`: ModuleID = "org.scala-lang" % "scala-compiler" % scala logScalaExclude
    val `scala-reflect`: ModuleID  = "org.scala-lang" % "scala-reflect"  % scala logScalaExclude
    val `scala-library`: ModuleID  = "org.scala-lang" % "scala-library"  % scala logsExclude
  }

  /**
   * Define las librerías necesarias para pruebas.
   *
   * Orden alfabético.
   */
  private[Dependencies] object TestDep {

    import Versions._


  }

  import Dependencies.CompileDep._
  import Dependencies.TestDep._

  val `scala-libs`: Seq[ModuleID] = Seq(`scala-compiler`, `scala-reflect`, `scala-library`)
}
