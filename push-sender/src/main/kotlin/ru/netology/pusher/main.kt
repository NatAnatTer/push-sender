package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken("dyWrZ7A-RdWnFnx4-QhQTY:APA91bGmr7B27B-hef2vXEfEDb4WH1tpl2vPi_KP2l357sBXV-S0-krI6nNROdDaJpD-GdLxKy47qZWNU1qqoKilKQhMr7FihLhja3r5Fc37rxf7TOYWA-I14uSKKbMeRyzEL-hkbW3l")
        .build()

    FirebaseMessaging.getInstance().send(message)
}
