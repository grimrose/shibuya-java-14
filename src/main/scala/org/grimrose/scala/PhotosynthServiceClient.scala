package org.grimrose.scala

import scala.concurrent.{ ExecutionContext, Future }

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

trait SkinnyHttpClientsAsync extends scalaxb.HttpClientsAsync {
  lazy val httpClient = new SkinnyHttpClient {}

  trait SkinnyHttpClient extends HttpClient {

    import skinny.http._

    def request(in: String, address: java.net.URI, headers: Map[String, String]): concurrent.Future[String] = {
      val req: Request = Request(address.toString)
      headers.foreach { case (k, v) => req.header(k, v) }
      val contentType = "text/xml; charset=utf-8"
      req.body(in.getBytes(), contentType)
      HTTP.asyncPost(req).map(_.asString)
    }
  }

}
