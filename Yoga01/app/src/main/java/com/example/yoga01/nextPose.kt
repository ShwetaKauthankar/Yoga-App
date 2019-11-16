package com.example.yoga01

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.nextpose.*

class nextPose: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nextpose)

        var  i:Int
        var  image:String
        i = intent.getIntExtra("val",0)
        image=intent.getStringExtra("image")

        val view = ImageView(this)
       // nextimg.setBackgroundResource(image)
        Picasso
            .get() // give it the context
            .load(image) // load the image
            .into(nextimg)

        btnNext.setOnClickListener {

            var intent = Intent(this,startSession::class.java)
            intent.putExtra("val",i)
            startActivity(intent)

        }


    }
}