package br.unb.cic.wc.dataspaces

import scala.collection.mutable.{Map,Queue}

class ThreadClass(wordspace: Queue[String], stop_words: List[String]) extends Thread {
  var freq_space: Map[String, Int] = Map.empty[String, Int]
  override def run(): Unit = {
    freq_space = ProcessWords.count_words(wordspace, stop_words)
  }

}
