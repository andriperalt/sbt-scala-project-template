// -----------------------------------------------------
// Configuration file for plugin 'sbt-release'
// https://github.com/sbt/sbt-release
// -----------------------------------------------------

// ---------------------
// Settings
// ---------------------

import sbtrelease.{ Version, _ }

credentials += Credentials(Path.userHome / ".ribbonie" / ".credentials")

pomIncludeRepository := { _ => false }

publishArtifact in Test := true

publishMavenStyle := true

publishTo := Option("Ribbonie Nexus Snapshots Publish TO" at "http://nexus.ribbonie.com/content/repositories/binaries-snapshots")

releaseCommitMessage := s"Definiendo siguiente version de desarrollo a ${version.value}"

releaseNextVersion := { ver => Version(ver).map(_.bumpBugfix.asSnapshot.string).getOrElse(versionFormatError) }

releaseTagComment := s"Liberando version de desarrollo ${version.value}"

releaseVersion := { ver => Version(ver).map(_.asSnapshot.string).getOrElse(versionFormatError) }

// -----------------------
// Custom settings
// -----------------------
