package Persisters

import ujson.Value

trait JsonPrinter extends Printer {
  def flush[A](key:A, value: String, data: Value.Value):Option[Int]={
    data(key.toString) = value
    Some(200)
  }
  def openFile(path: String, name: String, format: String): Either[String, Value.Value]={
    try{
    val jsonString = os.read(os.pwd/"data"/"json"/s"${path}"/s"${name}"/s"${format}")
    val data = ujson.read(jsonString)
    Right(data)
    }
    catch {
      case e:Error => Left(e.toString)
      case _: Throwable=> Left("unrecognized error")
    }
  }
  def closeFile(path: String, name: String, format: String, data: Value.Value): Either[String, String]={
    try{
      os.write(os.pwd/"data"/"json"/s"${path}"/s"${name}"/s"${format}", data)
      Right("operation successfull")
    }
    catch{
      case e: Error=> Left(e.toString)
      case _: Throwable=>Left("unrecognized error in writing")
    }
  }

}
