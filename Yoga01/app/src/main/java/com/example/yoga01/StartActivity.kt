package com.example.yoga01

import android.content.Intent
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)


        var beginner:ImageView=findViewById(R.id.beginner)
        var intermediate:ImageView=findViewById(R.id.intermediate)
        var expert:ImageView=findViewById(R.id.expert)

        beginner.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra("label","Beginner")
            startActivity(intent)
        }

        intermediate.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra("label","intermediate")
            startActivity(intent)
        }

        expert.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra("label","expert")
            startActivity(intent)
        }



    }
}
