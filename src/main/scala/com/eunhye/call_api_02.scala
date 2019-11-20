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

import com.google.api.services.translate.Translate
import com.google.cloud.translate.Translate.TranslateOption
import com.google.cloud.translate.TranslateOptions

object call_api_02 extends App {

    val translate = TranslateOptions.getDefaultInstance.getService
    val translation = translate.translate("¡Hola Mundo!")
    println(("Translated Text:", translation.getTranslatedText()))
}
