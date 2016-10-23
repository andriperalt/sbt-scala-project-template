import sbt._

/**
  * Contains dependencies versions
  */
object Versions {

  lazy val logbackVersion: String = "1.1.6"
  lazy val scalaLoggingVersion: String = "3.1.0"
  lazy val ficusVersion: String = "1.2.3"
  lazy val scalaTimeVersion: String = "2.10.0"

  lazy val scalazVersion: String = "7.2.1"

  lazy val specs2Version: String = "3.7.2"
  lazy val specs2ScalazVersion: String = "0.4.0"

}

/**
  * Contains dependencies
  */
object Dependencies {

  /**
    * Contains compilation modules
    */
  private[Dependencies] object CompileModules {

    lazy val logbackCore: ModuleID = "ch.qos.logback" % "logback-core" % Versions.logbackVersion
    lazy val logbackClassic: ModuleID = "ch.qos.logback" % "logback-classic" % Versions.logbackVersion
    lazy val scalaLogging: ModuleID = "com.typesafe.scala-logging" %% "scala-logging" % Versions.scalaLoggingVersion
    lazy val ficus: ModuleID = "com.iheart" %% "ficus" % Versions.ficusVersion
    lazy val scalaTime: ModuleID = "com.github.nscala-time" %% "nscala-time" % Versions.scalaTimeVersion

    lazy val scalaz: ModuleID = "org.scalaz" %% "scalaz-core" % Versions.scalazVersion

  }

  /**
    * Contains testing modules
    */
  private[Dependencies] object TestModules {

    lazy val specs2: ModuleID = "org.specs2" %% "specs2-core" % Versions.specs2Version % "test"
    lazy val specs2Scalaz: ModuleID = "org.typelevel" %% "scalaz-specs2" % Versions.specs2ScalazVersion % "test"

  }

  import Dependencies.{CompileModules => C, TestModules => T}

  private[Dependencies] val utils: Seq[ModuleID] = Seq(C.logbackCore, C.logbackClassic, C.scalaLogging, C.ficus, C.scalaTime)
  private[Dependencies] val functional: Seq[ModuleID] = Seq(C.scalaz)
  private[Dependencies] val test: Seq[ModuleID] = Seq(T.specs2, T.specs2Scalaz)

  val all: Seq[ModuleID] = utils ++ functional ++ test
}
