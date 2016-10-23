addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.1.0-RC2") // Config -> build.sbt, packager.sbt

addSbtPlugin("com.github.gseitz" % "sbt-release" % "1.0.3") // Config -> version.sbt, release.sbt

addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0") // Config -> build.sbt, scalariform.sbt

addSbtPlugin("org.scalastyle" % "scalastyle-sbt-plugin" % "0.8.0") // Config -> build.sbt, scalastyle-config.xml

addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.3.5") // Config -> scoverage.sbt

addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.1.10") // Config -> updates.sbt
