import ScalaxbKeys._

val skinnyVersion = "2.0.7"

lazy val root = (project in file(".")).settings(
  organization := "org.grimrose",
  name := "scalaxb-skinny-http-client",
  version := "1.0",
  scalaVersion := "2.11.7",
  resolvers ++= Seq(
    "sonatype releases" at "https://oss.sonatype.org/content/repositories/releases"
  ),
  // https://github.com/sbt/sbt/issues/2217
  fullResolvers ~= { _.filterNot(_.name == "jcenter") },
  dependencyOverrides := Set(
    "org.scala-lang" % "scala-library" % scalaVersion.value,
    "org.scala-lang" % "scala-reflect" % scalaVersion.value,
    "org.scala-lang" % "scala-compiler" % scalaVersion.value,
    "org.scala-lang.modules" %% "scala-xml" % "1.0.5",
    "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
    "org.slf4j" % "slf4j-api" % "1.7.16"
  ),
  libraryDependencies ++= Seq(
    "org.skinny-framework" %% "skinny-framework" % skinnyVersion,
    "org.skinny-framework" %% "skinny-task" % skinnyVersion,
    "org.skinny-framework" %% "skinny-http-client" % skinnyVersion,
    // @sbt-scalaxb
    "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",
    "org.skinny-framework" % "skinny-logback" % "1.0.7"
  ),
  scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature"),
  packageName in(Compile, scalaxb) := "org.grimrose.scala",
  sourceGenerators in Compile <+= scalaxb in Compile
).settings(scalariformSettings)
 .settings(scalaxbSettings)
