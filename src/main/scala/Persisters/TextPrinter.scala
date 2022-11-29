package Persisters
import java.io._

trait TextPrinter extends Printer{

  def openFile(path:String,name: String, format:String): Either[String, PrintWriter] ={
    try {
      Right(new PrintWriter(new File(s"src/main/data/text/${name}${format}")))
    }//
    catch{
      case e: Error => Left(e.toString)
      case a: Any =>Left(a.toString)

    }
  }
  def flush[A](key:A, value: String, pw: PrintWriter):Option[Int]={
    pw.write(s"${key.toString}, ${value}\n")
    Some(200)
  }
  def closeFile(pw: PrintWriter): Either[String, String]={
    try{
      pw.close()
      Right("Success")
    }
    catch{
      case e: Error=> Left(e.toString)
      case _: Throwable => Left("Failure")
    }
  }

}
