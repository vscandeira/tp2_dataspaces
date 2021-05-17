package br.unb.cic.wc.dataspaces

import scala.collection.mutable.{Map,Queue}
import akka.actor.Actor

class ActorClass(wordspace: Queue[String], stopwords: List[String]) extends Actor {
  var freq_space: Map[String, Int] = Map.empty[String, Int]
  override def receive = {
    case CountWords() =>
      count_words(wordspace, stopwords)
    case TakeFreqs() =>
      sender() ! freq_space
      context.system.terminate()
  }

  def increment_count(word: String, freqs: Map[String, Int]): Map[String, Int] = {
    val count = if (!freqs.contains(word)) 1 else freqs.apply(word) + 1
    return freqs + (word -> count)
  }

  def count_words(wordspace: Queue[String], stop_words: List[String]) = {
    while (!wordspace.isEmpty) {
      val word = wordspace.dequeue
      freq_space = if (!stop_words.contains(word) && (word!=null) && (word!="")) increment_count(word, freq_space) else freq_space
    }
  }
}
