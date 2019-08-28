package uk.gov.hmrc.authmongotests.repositories

import play.modules.reactivemongo.ReactiveMongoComponent
import uk.gov.hmrc.authmongotests.helpers.BaseISpec

import scala.concurrent.ExecutionContext.Implicits.global
import uk.gov.hmrc.authmongotests.repositorys.{TestRepository, Trash}
import uk.gov.hmrc.mongo.MongoConnector

class TrashRepoSpec extends BaseISpec {
//  implicit val ec = global
  implicit val mongo = new ReactiveMongoComponent {
    override def mongoConnector: MongoConnector = MongoConnector(s"mongodb://127.0.0.1:27017/test-${this.getClass.getSimpleName}")
  }
  val repo = app.injector.instanceOf[TestRepository]

  (1 to 100).toList.map { l =>
    "TrashRepo" should {
      s"happily insert garbage $l" in {
        val result = await(repo.put(Trash(s"stuff $l", s"more stuff $l")))
        result.ok shouldBe true
      }
    }
  }
}
