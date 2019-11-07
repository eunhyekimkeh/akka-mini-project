package com.c3po.translator

import java.util.regex.Pattern

import akka.actor.typed.ActorSystem
import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
import com.c3po.translator.C3_PO.languageMapper
import com.c3po.translator.LanguageMapper.Translate

object LanguageTranslator {
  case object Check
  def props(languageMapper: ActorRef) = Props(new LanguageTranslator(languageMapper))
}

class LanguageTranslator(languageMapper: ActorRef) extends Actor with ActorLogging {

  import LanguageTranslator._

  override def preStart = {
    log.info("Start C3_PO Translator !!!")
    self ! Check
  }

  def receive = {
    case Check =>
      import scala.io.StdIn.readLine
      readLine match {
        case msg =>
          log.info(">>>> Source Message : {}", msg)
          if(Pattern.matches("^[0-9가-힣]*$", msg)){
            languageMapper ! Translate(self, msg, "ko")
          }else if (Pattern.matches("^[0-9a-zA-Z]*$", msg)){
            languageMapper ! Translate(self, msg, "en")
          }
          self ! Check
      }
  }
}
