package com.bookshelf

import java.io.FileInputStream
import com.google.firebase.FirebaseOptions
import com.google.firebase.FirebaseApp
import com.google.firebase.database._
import com.google.firebase.auth.FirebaseCredentials

class FirebaseDb() {

  def init(): Unit = {
    val serviceAccount: FileInputStream = new FileInputStream("src/main/resources/firebasecred.json")
    val options: FirebaseOptions = new FirebaseOptions.Builder()
      .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
      .setDatabaseUrl("https://namehere.firebaseio.com")
      .build()


    FirebaseApp.initializeApp(options)

    val ref: DatabaseReference = FirebaseDatabase
      .getInstance()
      .getReference()
    ref.addListenerForSingleValueEvent(new ValueEventListener() {
      override def onDataChange(dataSnapshot: DataSnapshot) {
        val document: Object = dataSnapshot.getValue()
        println(document)
      }
      override def onCancelled(error: DatabaseError) {
        println("CANCELLED")
      }
    })

    val usersRef: DatabaseReference = ref.child("users")

    usersRef.child("alanisawesome").setValueAsync(("June 23, 1912", "Alan Turing"))
    usersRef.child("gracehop").setValueAsync(("December 9, 1906", "Grace Hopper"))
  }
}