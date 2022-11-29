package Database

import Formats.{Format, JsonText, StringText}
import Persisters.Persister

import java.nio.file.Files
import java.nio.file.Paths

object PersistingDatabase extends Database with Reader{
  def apply[A]( map: Map[A, String] = Map[A, String](), format: Format=StringText(), path: String="", name: String="default"): PersistingDatabase[A] ={
    val dataPath =format match{
      case _: JsonText => "data/json/" ++ path ++"/" ++name++".json"
      case _: StringText =>"data/txt/" ++ path ++"/" ++name++".txt"
    }
    if (map.keys.size>0 || Files.exists(Paths.get("/tmp/baeldung.txt")) ) {
      new PersistingDatabase[A](map, format, path, name)
    }
    else{
      //TODO: implement file read from datapath
      ???
    }
  }
}


case class PersistingDatabase[A](override val map: Map[A, String] = Map[A, String](), override val format: Format=StringText(), path: String="", name: String="default") extends Database[A] {


  //create
  override def push(key: A, value: String): PersistingDatabase[A]={
    new PersistingDatabase[A](map ++ Map[A,String](key->value), format, path, name)
  }

  override def pop(key: A): Database[A]={
    new PersistingDatabase[A](map.--(List(key)))
  }


  override def flush():Database[A]={
    Persister(format).persist(path, name, map) match{
          case Left(s)=>println(s)
          case Right(s)=>println(s)
        }
        PersistingDatabase[A]()
  }

}
