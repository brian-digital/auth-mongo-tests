/*
 * Copyright 2019 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.authmongotests.repositorys

import akka.Done
import javax.inject.Inject
import play.api.libs.json.{Format, Json}
import play.modules.reactivemongo.ReactiveMongoComponent
import reactivemongo.api.commands.WriteResult
import reactivemongo.bson.BSONObjectID
import uk.gov.hmrc.mongo.ReactiveRepository

import scala.concurrent.{ExecutionContext, Future}

case class Trash(garbage: String, rubbish: String)

object Trash {
  implicit val format: Format[Trash] = Json.format[Trash]
}

class TestRepository @Inject()()(implicit mongo:ReactiveMongoComponent)
  extends ReactiveRepository[Trash, BSONObjectID]("trash",mongo.mongoConnector.db, Trash.format){

  def put(trash: Trash)(implicit ec: ExecutionContext): Future[WriteResult] =
    insert(trash)
}
