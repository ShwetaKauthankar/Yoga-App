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

            displayBMI(bmiResult)
        }
    }

    private fun displayBMI(bmiResult: Float) {
        var bmiLabel:String

        bmiLabel = ""

        if (bmiResult>=0 && bmiResult <= 15f){
            bmiLabel = "Very Severely underweight"
        }
        else if (bmiResult>=15f && bmiResult <= 16f){
            bmiLabel = "Severely underweight"
        }
        else if (bmiResult>=16f && bmiResult <= 18.5f){
            bmiLabel = "Underweight"
        }
        else if (bmiResult>=18.5f && bmiResult <= 25f){
            bmiLabel = "Normal"
        }
        else if (bmiResult>=25f && bmiResult <= 30f){
            bmiLabel = "Overweight"
        }
        else if (bmiResult>=30f && bmiResult <= 35f){
            bmiLabel = "Obese Class i"
        }
        else if (bmiResult>=35f && bmiResult <= 40f){
            bmiLabel = "Obese Class ii"
        }
        else {
            bmiLabel = "Obese Class iii"
        }
        bmiLabel = bmiResult.toString() +"\n\n "+ bmiLabel

        bmi.text=bmiLabel
    }


}