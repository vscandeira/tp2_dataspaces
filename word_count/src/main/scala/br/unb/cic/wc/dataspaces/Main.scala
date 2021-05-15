package br.unb.cic.wc.dataspaces

import scala.collection.immutable.{Map, Queue}
import scala.io.Source

object Main extends App() {
  // primeiro parâmetro é arquivo com stopwords e segundo parâmetro é arquivo de texto
  val stop_filename = args(0)
  val text_filename = args(1)

  val regex = "[,.:;!?()/{}\\[\\]]".r
  val stop_words = Source.fromFile(stop_filename).getLines.toList
  val text_array = regex.replaceAllIn(Source.fromFile(text_filename).getLines.mkString("\n").toLowerCase(), "").split("[ |\n]")
  val word_space: Queue[String] = Queue(text_array: _*)
  val freq_space: Map[String, Int] = processWords.count_words(word_space, stop_words, Map.empty[String, Int])
  println()
  println("Resultado da contagem: ")
  println()
  val lista_freq = freq_space.toList.sortBy(_._2).reverse
  lista_freq.dropRight(lista_freq.length - 10).foreach(freq => println(freq._1 + " - " + freq._2 + " times"))
  println()

}
