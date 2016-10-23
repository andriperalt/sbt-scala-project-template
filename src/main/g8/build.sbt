import sbt._

// -----------------------------------------------------
// Build information for project $name$
// -----------------------------------------------------
organization := "$project_organization$"
name := "$name;format="norm"$"
description := "$project_description$"

// -----------------------------------------------------
// Scala compiler configurations
// -----------------------------------------------------
scalaVersion := "$scala_version$"
scalacOptions ++= Seq(
  "-target:jvm-$jvm_version$", // Force compile with specified java version.
  "-deprecation", // Emit warning and location for usages of deprecated APIs.
  "-encoding", "UTF-8", // Specify character encoding used by source files.
  "-feature", // Emit warning and location for usages of features that should be imported explicitly.
  "-language:existentials", // Existential types (besides wildcard types) can be written and inferred
  "-language:higherKinds", // Allow higher-kinded types
  "-language:implicitConversions", // Allow definition of implicit functions called views
  "-unchecked", // Enable detailed unchecked (erasure) warnings
  "-Xfatal-warnings", // Fail the compilation if there are any warnings.
  "-Xlint", // Enable recommended additional warnings.
  "-Yno-adapted-args", // Warn if an argument list is modified to match the receiver.
  "-Ywarn-dead-code", // Warn if dead code.
  "-Ywarn-numeric-widen",
  "-Ywarn-value-discard", // Warn when non-Unit expression results are unused.
  "-Xfuture", // Turn on future language features.
  "-Xcheckinit" // Checks objects initialization
)

// -----------------------------------------------------
// Resolvers and dependencies
// -----------------------------------------------------
resolvers += Resolver.jcenterRepo
libraryDependencies ++= Dependencies.all

// -----------------------------------------------------
// Projects definitions
// -----------------------------------------------------
lazy val root: Project = Project(
  "$name;format="norm"$",
  file(".")
).enablePlugins(
  JavaAppPackaging
).disablePlugins(
  SbtScalariform
)

// -----------------------------------------------------
// Custom tasks
// -----------------------------------------------------
lazy val customCompile: TaskKey[Unit] = taskKey[Unit]("customCompile")
customCompile := Def.sequential (
  com.timushev.sbt.updates.UpdatesKeys.dependencyUpdates.in(Compile).toTask,
  com.typesafe.sbt.SbtScalariform.ScalariformKeys.format.in(Compile).toTask,
  org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Compile).toTask("")
).value

lazy val customTest: TaskKey[Unit] = taskKey[Unit]("customTest")
customTest := Def.sequential (
  com.timushev.sbt.updates.UpdatesKeys.dependencyUpdates.in(Test).toTask,
  com.typesafe.sbt.SbtScalariform.ScalariformKeys.format.in(Test).toTask,
  org.scalastyle.sbt.ScalastylePlugin.scalastyle.in(Test).toTask("")
).value

(compile in Compile) <<= (compile in Compile).dependsOn(customCompile)
(test in Test) <<= (test in Test).dependsOn(customTest)
