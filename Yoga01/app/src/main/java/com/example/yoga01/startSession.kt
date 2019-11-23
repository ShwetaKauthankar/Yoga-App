package com.example.yoga01

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.start_session.*
import java.util.*
import kotlin.collections.ArrayList

class startSession: AppCompatActivity() {



   //val image = intArrayOf(R.drawable.down, R.drawable.mountain,R.drawable.downward)
    var image= mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_session)




        // intialization for timer
        val imageflip : pl.droidsonroids.gif.GifImageView
        var timerView: TextView
        var start: Button
        var pause: Button
        var dec:Boolean
        dec=true
        timerView = findViewById(R.id.timer)
        start = findViewById(R.id.btnStart)
        pause = findViewById(R.id.btnpause)
        imageflip=findViewById(R.id.v_flipper)
        var i :Int


        timerView.text = "10"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
        var timer: CountDownTimer? = null
        var left = 0
        var time = 10000

        i = intent.getIntExtra("val", 0)
        Log.d("Start session ==>", "$i")
        if(i==9){
            startActivity(
                Intent(this@startSession,MainActivity::class.java)

            )
            finish()
        }



        // code
        val db = FirebaseFirestore.getInstance()
        db.collection("yoga-exercise")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                   // Log.d("main==>", "${document.id} => ${document.data}")
                   // list.add(Yoga(document.data.get("pose").toString(),document.data.get("name").toString()))
                    image.add(document.data.get("pose").toString())
                }

                val view = ImageView(this)
                //imageflip.setBackgroundResource(image[i])
                /*
                Picasso
                    .get() // give it the context
                    .load(image[i]) // load the image
                    .into(imageflip) // select the ImageView to load it into
                */
                Glide.with(this)
                    .load(image[i])
                    .into(imageflip)

                start.setOnClickListener {

                    if (dec == true){
                        dec=false

                        timer = object : CountDownTimer(time.toLong(), 1000) {
                            override fun onTick(millisUntilFinished: Long) {
                                left = millisUntilFinished.toInt() / 1000
                                timerView.text = left.toString() + ""
                            }

                            override fun onFinish() {

                                i++
                                Log.d("Start session bstnp==>", "$i")
                                startActivity(


                                    Intent(this@startSession, nextPose::class.java)
                                        .putExtra("image", image[i])
                                        .putExtra("val", i)
                                )
                                finish()
                            }
                        }.start()
                }
                }
                pause.setOnClickListener {
                    dec=true
                    if (timer != null) {
                        timer!!.cancel()
                        time = left * 1000
                    }
                }



            }
            .addOnFailureListener { exception ->
                Log.w("man==>", "Error getting documents.", exception)
            }
        //

    }


}