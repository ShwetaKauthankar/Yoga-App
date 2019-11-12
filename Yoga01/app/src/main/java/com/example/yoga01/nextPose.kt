package com.example.yoga01

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.nextpose.*

class nextPose: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nextpose)

        var  i:Int
        var  image:Int
        i = intent.getIntExtra("val",0)
        image=intent.getIntExtra("image",0)

        val view = ImageView(this)
        nextimg.setBackgroundResource(image)

        btnNext.setOnClickListener {

            var intent = Intent(this,startSession::class.java)
            intent.putExtra("val",i)
            startActivity(intent)

        }


    }
}