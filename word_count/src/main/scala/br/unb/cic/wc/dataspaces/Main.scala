package br.unb.cic.wc.dataspaces

import scala.collection.mutable.{Map, Queue}
import scala.io.Source
import scala.concurrent.{Await,Future}
import akka.actor.{ActorSystem, PoisonPill, Props}

object Main extends App() {
  val wordCount = ActorSystem("WordCount")
  // primeiro parâmetro é arquivo com stopwords e segundo parâmetro é arquivo de texto
  val stop_filename = args(0)
  val text_filename = args(1)

  val regex = "[,.:;!?()/{}\\[\\]]".r
  val stop_words = Source.fromFile(stop_filename).getLines.toList
  val text_array = regex.replaceAllIn(Source.fromFile(text_filename).getLines.mkString("\n").toLowerCase(), "").split("[ |\n]")

  val threads = 5
  var word_space: Queue[String] = Queue(text_array: _*)
  var freq_space: Map[String, Int] = Map.empty[String, Int]
  val actors = new Array[ActorClass](threads)
  val arr_freqs = new Array[Map[String, Int]](threads)

  /*

  for (x <- 1 to threads) {
    val actor = wordCount.actorOf(Props(classOf[ActorClass], word_space, stop_words))
    actors.update(x-1, actor)
  }
  for (actor <- actors)
    actor ! CountWords()
  */
  for (x <- 1 to threads)
    arr_freqs.update(x-1, actors(x).getFreq())
  for (freqs <- arr_freqs) {
    for (tuple <- freqs) {
      val count = if (freq_space.contains(tuple._1)) freq_space.get(tuple._1).get + tuple._2 else tuple._2
      freq_space += (tuple._1 -> count)
    }
  }
  println()
  println("Resultado da contagem: ")
  println()
  val lista_freq = freq_space.toList.sortBy(_._2).reverse
  lista_freq.dropRight(lista_freq.length - 10).foreach(freq => println(freq._1 + " - " + freq._2 + " times"))
  println()

}
