package com.eunhye

import java.io.FileInputStream

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.translate.Translate.TranslateOption
import com.google.cloud.translate.v3beta1.{LocationName, TranslateTextRequest, TranslateTextResponse, TranslationServiceClient}
import com.google.common.collect.Lists
import com.google.cloud.translate.{Translate, TranslateOptions, Translation}
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import java.io.ByteArrayInputStream
import java.nio.file.{Path, Paths}
object call_api_03 extends App {

    var text = "how are you?"; // Text for translation. [Q1] var vs val

    // Instantiates a client
    val translate : Translate  = TranslateOptions.getDefaultInstance().getService();

    // Translates some text into Russian
    val translation : Translation =
        translate.translate(
            text,
            TranslateOption.sourceLanguage("en"),
            TranslateOption.targetLanguage("ru"));

    System.out.printf("Text: %s%n", text);
    System.out.printf("Translation: %s%n", translation.getTranslatedText());

}
