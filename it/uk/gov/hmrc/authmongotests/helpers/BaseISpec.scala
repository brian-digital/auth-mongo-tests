package uk.gov.hmrc.authmongotests.helpers

import akka.util.Timeout
import org.scalatest.{Matchers, WordSpec}
import play.api.mvc.Result
import play.api.test.WsTestClient
import uk.gov.hmrc.integration.ServiceSpec

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._

trait BaseISpec extends WordSpec with Matchers with ServiceSpec with WsTestClient {

  val externalServices : Seq[String] = Seq()

  implicit val timeout : Duration = 5 minutes

  def await[A](future: Future[A])(implicit timeout: Duration): A = Await.result(future, timeout)

//  def status(of: Future[Result])(implicit timeout: Timeout): Int = Await.result(of, timeout.duration).header.status
}
