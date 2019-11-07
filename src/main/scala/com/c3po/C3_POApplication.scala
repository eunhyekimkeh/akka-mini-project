package com.c3po

import akka.actor.ActorSystem
import com.c3po.translator.{LanguageMapper, LanguageTranslator}

//#main-class
object C3_POApplication extends App {
  //#actor-system
  val actorSystem = ActorSystem("LanguageMapper")
  val languageMapper = actorSystem.actorOf(LanguageMapper.props,"languageMapper")
  actorSystem.actorOf(LanguageTranslator.props(languageMapper), "languageTranslator")
  //#actor-system
}
