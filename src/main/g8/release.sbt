// -----------------------------------------------------
// Configuration file for plugin 'sbt-release'
// https://github.com/sbt/sbt-release
// -----------------------------------------------------
pomIncludeRepository := { _ => false }
publishMavenStyle := true
publishArtifact in Test := false
publishTo := {
  val nexusURL: String = "http://somewhere/nexus/"
  if (version.value.trim.endsWith("SNAPSHOT")) {
    Some("Nexus Snapshots" at nexusURL + "content/repositories/snapshots/")
  }
  else {
    Some("Nexus Releases" at nexusURL + "content/repositories/releases")
  }
}
credentials += Credentials("Sonatype Nexus Repository Manager", "somewhere", "user", "password")
