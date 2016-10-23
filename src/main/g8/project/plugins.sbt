addSbtPlugin("com.eed3si9n"      % "sbt-assembly"          % "0.14.3") // Config -> assembly.sbt

addSbtPlugin("net.virtual-void"  % "sbt-dependency-graph"  % "0.8.2")

addSbtPlugin("com.github.gseitz" % "sbt-release"           % "1.0.3") // Config -> version.sbt, release.sbt

addSbtPlugin("org.scalariform"   % "sbt-scalariform"       % "1.6.0") // Config -> build.sbt, scalariform.sbt

addSbtPlugin("org.scoverage"     % "sbt-scoverage"         % "1.4.0") // Config -> scoverage.sbt

addSbtPlugin("com.timushev.sbt"  % "sbt-updates"           % "0.2.0") // Config -> updates.sbt

addSbtPlugin("org.scalastyle"   %% "scalastyle-sbt-plugin" % "0.8.0") // Config -> build.sbt, scalastyle-config.xml
