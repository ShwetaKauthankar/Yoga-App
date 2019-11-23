package com.example.yoga01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class SignoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signout)

        val logoutButton=findViewById<Button>(R.id.logout)
        val userEmail = findViewById<TextView>(R.id.userEmail)
        val profile_image = findViewById<ImageView>(R.id.profile_image)


        userEmail.text = Auth.firebaseAuth.currentUser?.email

        if(Auth.firebaseAuth.currentUser?.photoUrl!=null){
            Picasso.get().load(Auth.firebaseAuth.currentUser?.photoUrl).into(profile_image)

        }


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