enablePlugins(SbtOsgi)

scalaVersion := "2.11.8"
organization := "org.o1"
name := "espresso-cup"
version := "0.0.1"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-target:jvm-1.8",
  "-unchecked",
  "-Ywarn-adapted-args",
  "-Ywarn-dead-code",
  "-Ywarn-numeric-widen",
  "-Ywarn-unused",
  "-Ywarn-value-discard",
  "-Xfuture",
  "-Xlint"
)

scalacOptions in (Compile, doc) ++= baseDirectory.map {
  (bd: File) => Seq[String](
     "-sourcepath", bd.getAbsolutePath //,
     //"-doc-source-url", "https://github.com/mslinn/changeMe/tree/master€{FILE_PATH}.scala"
  )
}.value

javacOptions ++= Seq(
  "-Xlint:deprecation",
  "-Xlint:unchecked",
  "-source", "1.8",
  "-target", "1.8",
  "-g:vars"
)

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-xml" % "2.11.+",
  "org.slf4j" %  "slf4j-api" % "1.7.21",
  "org.slf4j" %  "slf4j-simple" % "1.7.21",
  "org.slf4j" %  "osgi-over-slf4j" % "1.7.21",
  "org.osgi" %  "org.osgi.core" % "6.0.0",
  //"org.osgi" %  "org.osgi.compendium" % "4.3.0",
  //"org.apache.felix" %  "org.apache.felix.scr.ds-annotations" % "1.2.4" % "provided",
  "org.scalatest"     %% "scalatest"   % "3.0.0" % "test"
)

osgiSettings
OsgiKeys.bundleSymbolicName := "org.o1.espresso-cup"
OsgiKeys.exportPackage := Seq("org.o1.logging")
OsgiKeys.importPackage := Seq("org.sl4j")
OsgiKeys.privatePackage := Seq("org.o1.logging.slj4")

logLevel := Level.Warn

// Only show warnings and errors on the screen for compilations.
// This applies to both test:compile and compile and is Info by default
logLevel in compile := Level.Info

// Level.INFO is needed to see detailed output when running tests
logLevel in test := Level.Info

// define the statements initially evaluated when entering 'console', 'console-quick', but not 'console-project'
initialCommands in console := """|""".stripMargin

cancelable := true
