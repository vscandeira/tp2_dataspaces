package br.unb.cic.wc.dataspaces

import scala.collection.mutable.{Map, Queue}
import scala.io.Source
import scala.concurrent.{Await,Future}
import scala.concurrent.duration._

object Main extends App() {
  // primeiro parâmetro é arquivo com stopwords e segundo parâmetro é arquivo de texto
  val stop_filename = args(0)
  val text_filename = args(1)

  val regex = "[,.:;!?()/{}\\[\\]]".r
  val stop_words = Source.fromFile(stop_filename).getLines.toList
  val text_array = regex.replaceAllIn(Source.fromFile(text_filename).getLines.mkString("\n").toLowerCase(), "").split("[ |\n]")

  var word_space: Queue[String] = Queue(text_array: _*)
  var freq_space: Map[String, Int] = Map.empty[String, Int]
  //val ths: List[ThreadClass] = for(x <- 1 to 5)  new ThreadClass(word_space, stop_words)
  var ths: List[ThreadClass] = List.empty[ThreadClass]
  //for (th <- ths) {
  for (x <- 1 to 5) {
    var th = new ThreadClass()
    th.start()
    th.run()
    ths+(th)
  }
  val list_freq: List[Future[Map[String, Int]]] =

  println()
  println("Resultado da contagem: ")
  println()
  val lista_freq = freq_space.toList.sortBy(_._2).reverse
  lista_freq.dropRight(lista_freq.length - 10).foreach(freq => println(freq._1 + " - " + freq._2 + " times"))
  println()

}
