package org.o1.logging.slj4

import org.o1.logging.{Level, Logging}
import org.slf4j.{Logger, LoggerFactory}

import scala.annotation.switch

/**
  * Created by ricardo on 6/16/16.
  */
trait SLF4JLogging extends Logging {
  private lazy val logger:Logger = LoggerFactory.getLogger(getClass)

  @inline def log(level:Level.Value, msg: => Any, exception:Option[Throwable] = None): Unit = {
    (level: @switch) match {
      case Level.Error =>logger.error(msg.toString,exception.get)
      case Level.Warn =>logger.warn(msg.toString,exception.get)
      case Level.Info => logger.info(msg.toString,exception.get)
      case Level.Debug =>logger.debug(msg.toString)
      case _ => logger.trace(msg.toString, exception)
    }
  }
}