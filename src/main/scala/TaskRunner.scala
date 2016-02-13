import org.grimrose.scala.PhotosynthServiceClient
import skinny.json4s.JSONStringOps._

import scala.concurrent.Await
import scala.concurrent.duration.Duration

object TaskRunner extends skinny.task.TaskLauncher with skinny.logging.Logging {

  import scala.concurrent.ExecutionContext.Implicits.global

  val client = new PhotosynthServiceClient

  register("ping", (params) => {

    val f = client.ping()
    val result = Await.result(f, Duration.Inf)

    logger.info(result)
    logger.info(toPrettyJSONString(result))

  })

  register("get", (params) => {

    val id = "ff472390-10bd-4edc-b913-d20c4d639bb7"

    val f = client.getCollectionData(id)
    val result = Await.result(f, Duration.Inf)

    logger.info(result)
    logger.info(toPrettyJSONString(result))

  })

  register("info", (params) => {
    val f = client.getServerInfo()
    val result = Await.result(f, Duration.Inf)

    logger.info(result)
    logger.info(toPrettyJSONString(result))

  })

}
