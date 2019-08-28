import play.core.PlayVersion.current
import play.sbt.PlayImport._
import sbt.Keys.libraryDependencies
import sbt._

object AppDependencies {

  lazy val testScope: String = "test, it"

  val compile = Seq(

    "uk.gov.hmrc" %% "play-reactivemongo" % "6.2.0",
//    "uk.gov.hmrc"             %% "microservice-bootstrap"   % "10.6.0"
    "uk.gov.hmrc" %% "bootstrap-play-25" % "4.13.0"
  )

  val test = Seq(
  "org.scalatest"           %% "scalatest"                % "3.0.0"  % testScope,
  "com.typesafe.play"       %% "play-test"                % current  % testScope,
  "org.pegdown"             %  "pegdown"                  % "1.6.0"  % testScope,
  "org.scalatestplus.play"  %% "scalatestplus-play"       % "2.0.0"  % testScope,
  "org.mockito"             %  "mockito-core"             % "2.13.0" % testScope,
  "uk.gov.hmrc"             %% "service-integration-test" % "0.3.0"  % "it"
  )
  def apply(): Seq[ModuleID] = compile ++ test
}
