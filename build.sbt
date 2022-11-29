ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "SimpleHashLog"
  )
libraryDependencies += "com.lihaoyi" %% "upickle" % "2.0.0"
libraryDependencies +="com.lihaoyi" %% "os-lib" % "0.8.1"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.14"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % "test"