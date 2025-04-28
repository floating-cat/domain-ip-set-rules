val scala3Version = "3.6.4"

lazy val root = project
  .in(file("."))
  .settings(
    name := "domain-ip-set-rules-data",
    version := "0.1.0-SNAPSHOT",
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "com.comcast" %% "ip4s-core" % "3.7.0",
      "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",
      "org.xerial" % "sqlite-jdbc" % "3.49.1.0",
      "com.lihaoyi" %% "upickle" % "4.1.0"
    ),
    Compile / PB.targets := Seq(
      scalapb.gen(scala3Sources = true) -> (Compile / sourceManaged).value / "scalapb"
    ),
    // https://github.com/scalapb/ScalaPB/issues/1816
    // https://github.com/typelevel/sbt-tpolecat/issues/125
    Compile / scalacOptions += "-Wconf:src=target/scala[^/]*/src_managed/.*:silent"
  )
