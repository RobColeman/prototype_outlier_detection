name := "prototype_outlier_detection"

version := "1.0"

scalaVersion := "2.10.4"

resolvers ++= Seq(
  "Sonatype repo"                    at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype releases"                at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots"               at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype staging"                 at "http://oss.sonatype.org/content/repositories/staging",
  "Java.net Maven2 Repository"       at "http://download.java.net/maven/2/"
)

val sparkVersion = "1.5.1"
val breezeversion = "0.11.2"

libraryDependencies ++= Seq(
  "org.apache.spark"  %% "spark-core" % sparkVersion,
  "org.apache.spark"  %% "spark-streaming" % sparkVersion,
  "org.apache.spark" %% "spark-sql" % sparkVersion,
  "org.scalatest" %% "scalatest"          % "2.2.4"       % "test",
  "org.scalanlp" %% "breeze" % breezeversion,
  "org.scalanlp" %% "breeze-natives" % breezeversion,
  "org.apache.commons" % "commons-math3" % "3.3"
)