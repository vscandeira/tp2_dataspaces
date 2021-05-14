import scala.io.Source
import scala.collection.immutable.Queue

object Main extends App() {
  //args: Array[String]
  println("Exemplo de argumentos:")
  args.foreach(println)
  val stop_filename = args(0)
  val text_filename = args(1)

  // regex para retirar pontuações e caracteres especiais e pontuação
  val regex = "[,.:;!?()/{}\\[\\]]".r

  val stop_words = Source.fromFile(stop_filename).getLines.toList

  val word_space: Queue[String] = Queue(regex.replaceAllIn(Source.fromFile(text_filename).getLines.mkString, "").split(" "): _*)
  //val dequeue: (String, Queue[String]) = word_space.dequeue
  //var freq_space = new Queue[String]

  /*
  val lines = Source.fromFile(text_filename).getLines.toList
  val string_txt = Source.fromFile(text_filename).getLines.mkString

  println(lines.length)
  lines.slice(0,2).foreach(println)
  println(string_txt.length)
  val regex = "[,.:;!?()/{}\\[\\]]".r
  regex.replaceAllIn(string_txt,"").split(" ").slice(0,5).foreach(println)
  regex.replaceAllIn(lines(1),"").split(" ").foreach(println)
   */
}