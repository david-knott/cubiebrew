name := """plttest"""
organization := "com.chaosopher"

version := "1.0-SNAPSHOT"

// a comment
lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.6"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.chaosopeher.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.chaosopeher.binders._"

// main akka serial artifact
libraryDependencies += "ch.jodersky" %% "akka-serial-core" % "4.2.0"

// "fat" jar containing native libraries
libraryDependencies += "ch.jodersky" % "akka-serial-native" % "4.2.0" % "runtime"

// support for Akka streams
libraryDependencies += "ch.jodersky" %% "akka-serial-stream" % "4.2.0"