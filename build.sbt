name := """scalaxb-skinny-http-client"""

organization := "org.grimrose"

version := "1.0"

scalaVersion := "2.11.7"

val skinnyVersion = "2.0.5"

resolvers ++= Seq(
  "sonatype releases" at "https://oss.sonatype.org/content/repositories/releases"
)

dependencyOverrides := Set(
  "org.scala-lang" % "scala-library" % scalaVersion.value,
  "org.scala-lang" % "scala-reflect" % scalaVersion.value,
  "org.scala-lang" % "scala-compiler" % scalaVersion.value,
  "org.scala-lang.modules" %% "scala-xml" % "1.0.5",
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  "org.slf4j" % "slf4j-api" % "1.7.13"
)

libraryDependencies ++= Seq(
  "org.skinny-framework" %% "skinny-framework" % skinnyVersion,
  "org.skinny-framework" %% "skinny-task" % skinnyVersion,
  "org.skinny-framework" %% "skinny-http-client" % skinnyVersion,

  // @sbt-scalaxb
  "net.databinder.dispatch" %% "dispatch-core" % "0.11.2",

  "org.skinny-framework" % "skinny-logback" % "1.0.6"
)

scalacOptions ++= Seq("-unchecked", "-deprecation", "-feature")

import ScalaxbKeys._

scalaxbSettings

packageName in(Compile, scalaxb) := "org.grimrose.scala"

sourceGenerators in Compile <+= scalaxb in Compile
