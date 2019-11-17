package com.example.yoga01

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.yoga01.Auth

class Check : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val auth: Auth = Auth
        var intentLogin = Intent(this, SigninActivity::class.java)
        var intentHome = Intent(this, StartActivity::class.java)
        Log.d("Check","${auth.authenticated}")

        if (auth.authenticated) {
            startActivity(intentHome)
        }else{
            startActivity(intentLogin)
        }


    }
}