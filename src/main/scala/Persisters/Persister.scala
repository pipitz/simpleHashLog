package Persisters

import Formats.{Format, JsonText, StringText}

object Persister{
  def apply(format: Format): Persister={
    format match {
    case _: JsonText => JsonPersister()
    case _: StringText=> TextPersister()
    case _ => TextPersister()
    }
  }

}

abstract class Persister(){
  private val extention="default"
  def persist[A](path: String, name: String, mapVals: Map[A, String]): Either[String,String]

}
