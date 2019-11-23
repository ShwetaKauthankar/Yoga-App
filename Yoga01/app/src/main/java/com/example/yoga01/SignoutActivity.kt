package com.example.yoga01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SignoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signout)

        val logoutButton=findViewById<Button>(R.id.logout)
        val userEmail = findViewById<TextView>(R.id.userEmail)


        userEmail.text = if (Auth.firebaseAuth.currentUser?.email.isNullOrEmpty()) Auth.firebaseAuth.currentUser?.phoneNumber else Auth.firebaseAuth.currentUser?.email


        logoutButton.setOnClickListener {
            Auth.firebaseAuth.signOut()
            Auth.authenticated=false
            Log.d("SignoutActivity","${Auth.firebaseAuth.currentUser?.email}")
        }

        Auth.firebaseAuth.addAuthStateListener {
            if(!Auth.authenticated){
                this.finish()
                val loginIntent  = Intent(this,Check::class.java)
                startActivity(loginIntent)
            }
        }
    }
}