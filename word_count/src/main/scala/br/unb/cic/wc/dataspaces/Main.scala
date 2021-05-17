package br.unb.cic.wc.dataspaces

import scala.collection.mutable.{Map, Queue}
import scala.io.Source

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout

object Main extends App() {
  val wordCount = ActorSystem("WordCount")
  implicit val timeout = Timeout(10, SECONDS)

  // primeiro parâmetro é arquivo com stopwords e segundo parâmetro é arquivo de texto
  val stop_filename = args(0)
  val text_filename = args(1)
  val charset = args(2)

  val regex = "[,.:;!?()/{}\\[\\]]".r
  val stop_words = Source.fromFile(stop_filename).getLines.toList
  val text_array = regex.replaceAllIn(Source.fromFile(text_filename)(charset).getLines.mkString("\n").toLowerCase(), "").split("[ |\n]")

  val threads = 5
  var word_space: Queue[String] = Queue(text_array: _*)
  var freq_space: Map[String, Int] = Map.empty[String, Int]

  val actors = new Array[akka.actor.ActorRef](threads)
  var arr_freqs = new Array[Map[String, Int]](threads)
  val futures = new Array[Future[Any]](threads)

  for (x <- 1 to threads) {
    actors.update(x-1, wordCount.actorOf(Props(classOf[ActorClass], word_space, stop_words)))
    actors(x-1) ! CountWords()
    val future = actors(x-1) ? TakeFreqs()
    futures.update(x-1, future)
  }

  for (x <- 1 to threads) {
    arr_freqs.update(x-1, Await.result(futures(x-1), timeout.duration).asInstanceOf[Map[String, Int]])
  }

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
