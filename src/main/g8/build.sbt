import sbt._
import Keys._

name := "$name$"
organization := "$organization$"
version := "$version$"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  val sparkVersion = "2.0.0"

  Seq(
    // Apache Spark
    "org.apache.spark" %% "spark-core" % sparkVersion % Provided,
    "org.apache.spark" %% "spark-sql" % sparkVersion % Provided,
    // Config
    "com.typesafe" % "config" % "1.3.0",
    // ScalaTest
    "org.scalatest" %% "scalatest" % "2.2.6" % Test
  )
}

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-Ywarn-dead-code",
  "-language:_",
  "-target:jvm-1.8",
  "-encoding", "UTF-8"
)

exportJars := true

crossPaths := false

parallelExecution in Test := false

assemblyJarName in assembly := "$name$.jar"

// Add provided dependencies to classpath on `sbt run`
run in Compile <<= Defaults.runTask(fullClasspath in Compile, mainClass in (Compile, run), runner in (Compile, run))
