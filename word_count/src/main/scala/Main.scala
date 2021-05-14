import scala.io.Source
import scala.collection.immutable.Queue

object Main extends App() {
  println("Exemplo de argumentos:")
  args.foreach(println)
  // primeiro parâmetro é arquivo com stopwords e segundo parâmetro é arquivo de texto
  val stop_filename = args(0)
  val text_filename = args(1)

  // regex para retirar pontuações e caracteres especiais
  val regex = "[,.:;!?()/{}\\[\\]]".r
  val stop_words = Source.fromFile(stop_filename).getLines.toList
  val word_space: Queue[String] = Queue(regex.replaceAllIn(Source.fromFile(text_filename).getLines.mkString, "").split(" "): _*)
  //val dequeue: (String, Queue[String]) = word_space.dequeue

  //var freq_space = new Queue[String]

}