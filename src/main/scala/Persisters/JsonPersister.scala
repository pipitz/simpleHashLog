package Persisters



case class JsonPersister[A]() extends Persister with JsonPrinter {
  private val extention=".json"

  override def persist[A](path: String, name: String, mapVals: Map[A, String]): Either[String,String]={
    openFile(path, name, extention) match{
      case Left(s: String)=>
        println(s)
        Left(s)

      case Right(data)=>
        for{(x,y: String)<-mapVals} yield flush[A](x,y,data)
        closeFile(path,name,extention,data)
    }

  }
}
