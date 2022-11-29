package Database

import Formats.{Format, StringText}

class Database[A](val map: Map[A, String] = Map[A, String](), val format: Format=StringText()){
  def push(key: A, value: String): Database[A]={
    new Database[A](map ++ Map[A,String](key->value), format)
  }
  def pop(key: A): Database[A]={
    new Database[A](map.--(List(key)))
  }
  def get(key: A): String={
    map.get(key) match{
      case Some(s) => s
      case None => "Value not present"
    }
  }
  def flush():Database[A]={
    new Database[A]()
  }
}
