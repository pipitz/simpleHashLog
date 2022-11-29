import Database.{Database, PersistingDatabase}
import Formats.StringText

object Main {
  def main(args: Array[String]):Unit={
    val db=PersistingDatabase[Int](Map(), StringText() ,"./", "testString" )
    db.push(1, "hello").push(2, "world!").flush
  }
}
