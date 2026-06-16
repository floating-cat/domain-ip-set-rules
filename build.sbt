scalaVersion := "3.8.4"

lazy val root = rootProject
  .settings(
    name := "domain-ip-set-rules-data",
    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "com.comcast" %% "ip4s-core" % "3.8.0",
      "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",
      "org.xerial" % "sqlite-jdbc" % "3.53.2.0",
      "com.lihaoyi" %% "upickle" % "4.4.3"
    ),
    Compile / PB.targets := Seq(
      scalapb.gen(scala3Sources = true) -> (Compile / sourceManaged).value / "scalapb"
    )
  )
