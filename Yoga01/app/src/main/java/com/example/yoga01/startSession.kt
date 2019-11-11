package com.example.yoga01

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.start_session.*
import java.util.*
import kotlin.collections.ArrayList

class startSession: AppCompatActivity() {



    val image = intArrayOf(R.drawable.plank, R.drawable.mountain,R.drawable.downward)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_session)




        // intialization for timer
        var timerView: TextView
        var start: Button
        var pause: Button
        timerView = findViewById(R.id.timer)
        start = findViewById(R.id.btnStart)
        pause = findViewById(R.id.btnpause)
        var i=0


        timerView.text = "60 Seconds left"
        lateinit var timer: CountDownTimer
        var left = 0
        var time = 10000

        i = intent.getIntExtra("val", 0)
        if(i==2){
            startActivity(
                Intent(this@startSession,MainActivity::class.java)

            )
            finish()
        }

        val view = ImageView(this)
        view.setBackgroundResource(image[i])
        v_flipper.addView(view)
       // v_flipper.setFlipInterval(3000)
       // v_flipper.setAutoStart(true)
        v_flipper.setInAnimation(this , android.R.anim.slide_in_left)
        v_flipper.setOutAnimation(this , android.R.anim.slide_out_right)


        start.setOnClickListener {
            timer = object : CountDownTimer(time.toLong(), 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    left = millisUntilFinished.toInt() / 1000
                    timerView.text = left.toString() + "secound left"
                }

                override fun onFinish() {
                    // image slider
                  //   Toast.makeText(this@startSession, "finish", Toast.LENGTH_SHORT).show()
                    i++
                    startActivity(
                        Intent(this@startSession,nextPose::class.java)
                            .putExtra("image", image[i])
                            .putExtra("val", i)
                    )
                    finish()
                }
            }.start()
        }
        pause.setOnClickListener {
            if (timer != null) {
                timer!!.cancel()
                time = left * 1000
            }
        }

    }


}