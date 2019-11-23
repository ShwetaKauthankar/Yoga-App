package com.example.yoga01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BMIActivity : AppCompatActivity() {
    lateinit var weight: EditText
    lateinit var height: EditText
    lateinit var bmi: TextView
    lateinit var calculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        weight = findViewById(R.id.weight)
        height = findViewById(R.id.height)
        bmi = findViewById(R.id.bmi)
        calculate = findViewById(R.id.calculate)


        calculate.setOnClickListener {
            calculateBMI()
        }

    }

    private fun calculateBMI() {
        val heightStr :String= height.text.toString()
        val weightStr:String = weight.text.toString()

        if (heightStr != null && heightStr.isNotEmpty() && weightStr != null && weightStr.isNotEmpty()){
            var heightValue: Float = heightStr.toFloat()/100
            var weightValue: Float = weightStr.toFloat()

            var bmiResult : Float = weightValue / (heightValue * heightValue)

            Log.d("calculatebmi","${bmiResult}")
        }
    }


}