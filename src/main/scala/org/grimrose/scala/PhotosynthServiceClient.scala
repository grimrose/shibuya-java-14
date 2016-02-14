package org.grimrose.scala

import scala.concurrent.{ ExecutionContext, Future }
import _root_.generated._

class PhotosynthServiceClient(implicit val ctx: ExecutionContext) extends SoapClient {

  type CollectionId = String

  def ping(): Future[Option[String]] = {
    this.service.ping().map(_.PingResult)
  }

  def getCollectionData(id: CollectionId): Future[Option[CollectionResult]] = {
    this.service.getCollectionData(id, false).map(_.GetCollectionDataResult)
  }

  def getServerInfo(): Future[Option[ServerInfo]] = {
    this.service.getServerInfo(None).map(_.GetServerInfoResult)
  }

}

trait SoapClient extends PhotosynthServiceSoap12Bindings
  with scalaxb.SoapClientsAsync
  with SkinnyHttpClientsAsync

private object SkinnyHttpClientsAsync {
  val charset = "utf-8"
  val contentType = s"text/xml; charset=$charset"
}

trait SkinnyHttpClientsAsync extends scalaxb.HttpClientsAsync {
  import skinny.http._
  import SkinnyHttpClientsAsync._

  lazy val httpClient = new HttpClient {
    def request(in: String, address: java.net.URI, headers: Map[String, String]): Future[String] = {
      val req: Request = Request(address.toString)
      headers.foreach { case (k, v) => req.header(k, v) }
      req.body(in.getBytes(charset), contentType)
      HTTP.asyncPost(req).map(_.asString)
    }
  }
}
