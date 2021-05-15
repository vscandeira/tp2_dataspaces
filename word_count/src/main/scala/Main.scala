import scala.io.Source
import scala.collection.immutable.Queue
import scala.collection.immutable.Map

object process_words {
  def increment_count(word: String, freq_space: Map[String, Int]): Map[String, Int] = {
    val count = if (!freq_space.contains(word)) 1 else freq_space.apply(word) + 1
    return freq_space + (word -> count)
  }

  def count_words(wordspace: Queue[String], stop_words: List[String], freq_space: Map[String, Int]): Map[String, Int] = {
    if (wordspace.isEmpty) return freq_space
    val (word, rest) = wordspace.dequeue
    val freq2_space = if(!stop_words.contains(word)) count_words(rest, stop_words, increment_count(word, freq_space)) else count_words(rest, stop_words, freq_space)
    return freq2_space
  }

}

object Main extends App() {
  // primeiro parâmetro é arquivo com stopwords e segundo parâmetro é arquivo de texto
  val stop_filename = args(0)
  val text_filename = args(1)

  val regex = "[,.:;!?()/{}\\[\\]]".r
  val stop_words = Source.fromFile(stop_filename).getLines.toList
  val text_array = regex.replaceAllIn(Source.fromFile(text_filename).getLines.mkString("\n").toLowerCase(), "").split("[ |\n]")
  val word_space: Queue[String] = Queue(text_array: _*)
  val freq_space: Map[String, Int] = process_words.count_words(word_space, stop_words, Map.empty[String, Int])
  println()
  println("Resultado da contagem: ")
  println()
  val lista_freq = freq_space.toList.sortBy(_._2).reverse
  lista_freq.dropRight(lista_freq.length-10).foreach(freq => println(freq._1 + " - " + freq._2 + " times"))
  println()

}
