package com.eunhye

import com.google.api.services.translate.Translate
import com.google.api.services.translate.model.TranslationsListResponse
import com.google.api.services.translate.model.TranslationsResource
import java.util

// [java example code] https://codeday.me/ko/qa/20190516/556726.html
object call_api_04 extends App {
    // See comments on

    //   https://developers.google.com/resources/api-libraries/documentation/translate/v2/java/latest/
    // on options to set
//    val t = new Translate.Builder(com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport, com.google.api.client.json.gson.GsonFactory.getDefaultInstance, null).setApplicationName //Need to update this to your App-Name
//    "Stackoverflow-Example".build
//    val list = new Translate#Translations().list(util.Arrays.asList( //Pass in list of strings to be translated
//        "Hello World", "How to use Google Translate from Java"), //Target language
//        "ES")
//    //Set your API-Key from https://console.developers.google.com/
//    list.setKey("you-need-your-own-api-key")
//    val response = list.execute
//
//    import scala.collection.JavaConversions._
//
//    for (tr <- response.getTranslations) {
//        System.out.println(tr.getTranslatedText)
//    }
}
