package com.c3po.translator

import akka.actor.{Actor, ActorLogging, ActorSystem, Props}

//#main-class
object C3_PO extends App {
  //#actor-system
  val actorSystem = ActorSystem("LanguageMapper")
  val languageMapper = actorSystem.actorOf(LanguageMapper.props,"languageMapper")
  actorSystem.actorOf(LanguageTranslator.props(languageMapper), "languageTranslator")
  //#actor-system
}
//#main-class
