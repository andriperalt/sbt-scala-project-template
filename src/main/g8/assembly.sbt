// -----------------------------------------------------
// Configuration file for plugin 'sbt-assembly'
// https://github.com/sbt/sbt-assembly
// -----------------------------------------------------

import sbt.Keys._

// ---------------------
// Settings
// ---------------------

assemblyMergeStrategy in assembly := {
  x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

assemblyOutputPath in assembly := file(s"../${name.value}_${scalaBinaryVersion.value}-${version.value}.jar")

test in assembly := {}

// -----------------------
// Custom settings
// -----------------------
