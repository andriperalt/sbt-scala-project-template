package $project_organization$

import com.typesafe.scalalogging.LazyLogging

object Boot extends App with LazyLogging {

  def helloWorld: String = {
    "Hello world"
  }

  logger.info(helloWorld)
}
