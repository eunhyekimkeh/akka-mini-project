package com.c3po.translator

import akka.actor.{Actor, ActorLogging, ActorRef, Props}
import com.c3po.translator.LanguageMapper.{Sample, Ready, Translate}

object LanguageMapper {
  case object Ready
  case class Translate (actorRef: ActorRef, msg: String, country: String)
  case class Sample (code:String, source:String, target:String)

  def props = Props(new LanguageMapper)
}

class LanguageMapper extends Actor with ActorLogging{

  val ko = Sample("ko", "안녕", "hi")
  val en = Sample("en", "hi", "안녕")

  override def preStart = {
    //self ! Ready
  }

  def receive ={
    case Ready =>
      context.watch(sender)
    case translate: Translate =>
      log.info("Country Code : {}", translate.country)

      if(translate.country.equals("ko")){
        if(ko.source.equals(translate.msg)){
          log.info(">>>> Target Message[한국어 -> 영어] : {}", ko.target)
        }else{
          log.info(">> 해당하는 문구가 없습니다.")
        }
      }else if(translate.country.equals("en")){
        if(en.source.equals(translate.msg)){
          log.info(">>>> Target Message[영어 -> 한국어] : {}", en.target)
        }else{
          log.info(">> 해당하는 문구가 없습니다.")
        }
      }else{
        log.info(">> 지원하지 않는 언어 입니다.")
      }

      //log.info("Country : {}", translate.msg)
  }
}
