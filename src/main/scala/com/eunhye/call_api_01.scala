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
object call_api_01 extends App {

    val projectId = "solar-safeguard-234606"; // Id of the project.
    val location = null; // location name.
    var text = "how are you?"; // Text for translation. [Q1] var vs val
    val sourceLanguageCode = "en"; // Language code of text. e.g. "en"
    val targetLanguageCode = "ko"; // Language code for translation. e.g. "sr"

    //    if (text.length > 4500) text = text.substring(0, 4500) // text 최대 4500까지 가능

    val path : Path = Paths.get("/resources/sungho")
    println("check >>", path)
    val resourcesPath = getClass.getResource("/sungho.text")
    println(resourcesPath.getPath)

    val credentials: GoogleCredentials  = GoogleCredentials.fromStream(new FileInputStream("akka-mini-project/src/main/resources/sungho.text"))
        .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));


    val translationServiceClient = TranslationServiceClient.create()
    val locationName: LocationName = LocationName.newBuilder().setProject(projectId).setLocation(location).build();
    val translateTextRequest: TranslateTextRequest =
        TranslateTextRequest.newBuilder()
            .setParent(locationName.toString())
            .setMimeType("text/plain")
            .setSourceLanguageCode(sourceLanguageCode)
            .setTargetLanguageCode(targetLanguageCode)
            .addContents(text)
            .build();

    val response = translationServiceClient.translateText(translateTextRequest)
    System.out.format("Translated Text: %s", response.getTranslationsList.get(0).getTranslatedText)

}
