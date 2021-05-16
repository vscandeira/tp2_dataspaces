package br.unb.cic.wc.dataspaces

import scala.collection.mutable.{Map,Queue}
import akka.actor.Actor

class ActorClass(wordspace: Queue[String], stopwords: List[String]) extends Actor {
  var freq_space: Map[String, Int] = Map.empty[String, Int]
  override def receive = {
    case CountWords() =>
      freq_space = count_words(wordspace, stopwords)
  }

  def increment_count(word: String, freq_space: Map[String, Int]): Map[String, Int] = {
    val count = if (!freq_space.contains(word)) 1 else freq_space.apply(word) + 1
    return freq_space + (word -> count)
  }

  def count_words(wordspace: Queue[String], stop_words: List[String]): Map[String, Int] = {
    var freq_space: Map[String, Int] = Map.empty[String, Int]
    while (!wordspace.isEmpty) {
      val word = wordspace.dequeue
//      println("Processing: "+word)
      freq_space = if (!stop_words.contains(word)) increment_count(word, freq_space) else freq_space
    }
    return freq_space
  }

  def getFreq(): Map[String, Int] = freq_space

}
