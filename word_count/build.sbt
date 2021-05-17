scalaVersion := "2.13.3"

name := "word-count"
organization := "br.unb.cic.wc.dataspaces"
version := "0.1"

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.1.2"

val AkkaVersion = "2.6.9"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.3"