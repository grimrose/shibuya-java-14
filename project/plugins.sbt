scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

addSbtPlugin("org.scalaxb" % "sbt-scalaxb" % "1.3.0")
addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.6.0")

resolvers += Resolver.sonatypeRepo("public")
resolvers += "Sonatype OSS Releases" at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
