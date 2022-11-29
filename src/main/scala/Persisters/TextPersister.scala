package Persisters

case class TextPersister[A]() extends Persister with TextPrinter{
  private val extension=".txt"

  override def persist[A](path: String, name: String, mapVals: Map[A, String]): Either[String,String]={
    openFile(path, name, extension) match{
      case Right(pw)=>
        for{
          (x,y) <- mapVals
        } yield(flush[A](x,y,pw))
        closeFile(pw)
      case Left(s)=>Left(s)
    }
  }
}
