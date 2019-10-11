package com.example.yoga01

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.*
import kotlin.collections.ArrayList

class startSession: AppCompatActivity() {

    lateinit var vf: ViewFlipper
    lateinit var viewflipper : ViewFlipper
    val image = intArrayOf(R.drawable.mountain, R.drawable.plank,R.drawable.downward)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_session)

        vf = findViewById(R.id.v_flipper)

        for (images in image) {
            val view = ImageView(this)
            view.setBackgroundResource(images)
            vf.addView(view)
            vf.setFlipInterval(3000)
            vf.setAutoStart(true)
            vf.setInAnimation(this , android.R.anim.slide_in_left)
            vf.setOutAnimation(this , android.R.anim.slide_out_right)

        }
    }
}