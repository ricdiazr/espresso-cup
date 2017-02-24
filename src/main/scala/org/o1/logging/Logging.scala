package org.o1.logging

/**
  * Created by ricardo on 12/16/16.
  */
trait Logging {
  def log(level:Level.Value, msg: => Any, exception:Option[Throwable] = None) : Unit

  def error(msg: => Any,  exception:Option[Throwable] = None): Unit = {
    log(Level.Error, msg, exception)
  }

  def warn(msg: => Any,  exception:Option[Throwable] = None): Unit = {
    log(Level.Warn, msg, exception)
  }

  def info(msg: => Any,  exception:Option[Throwable] = None): Unit = {
    log(Level.Info, msg, exception)
  }

  def debug(msg: => Any,  exception:Option[Throwable] = None): Unit = {
    log(Level.Debug, msg, exception)
  }
}
