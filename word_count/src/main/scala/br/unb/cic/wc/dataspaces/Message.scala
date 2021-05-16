package br.unb.cic.wc.dataspaces
import scala.collection.mutable.{Map,Queue}

trait Message

case class CountWords() extends Message