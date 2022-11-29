package Database



trait Reader {
  def checkData[A](path: String, format: Formats.Format ): Map[A, String]= ???
}
