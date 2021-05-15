package br.unb.cic.wc.dataspaces

import scala.collection.immutable.{Map, Queue}

object processWords {
  def increment_count(word: String, freq_space: Map[String, Int]): Map[String, Int] = {
    val count = if (!freq_space.contains(word)) 1 else freq_space.apply(word) + 1
    return freq_space + (word -> count)
  }

  def count_words(wordspace: Queue[String], stop_words: List[String], freq_space: Map[String, Int]): Map[String, Int] = {
    if (wordspace.isEmpty) return freq_space
    val (word, rest) = wordspace.dequeue
    val freq2_space = if (!stop_words.contains(word)) count_words(rest, stop_words, increment_count(word, freq_space)) else count_words(rest, stop_words, freq_space)
    return freq2_space
  }

}
