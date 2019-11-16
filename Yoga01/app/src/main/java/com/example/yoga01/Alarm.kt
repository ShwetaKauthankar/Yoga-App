package com.example.yoga01

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.yogaalarm.PopTime
import com.example.yogaalarm.SaveData
import kotlinx.android.synthetic.main.alarm.*

class Alarm : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.alarm)

        val saveData= SaveData(applicationContext)
        tvShowTime.text=saveData.getHour().toString()+":"+saveData.getMinute().toString()
    }

    fun BuSetTime(view: View){
        val popTime= PopTime()
        val fm=supportFragmentManager
        popTime.show(fm,"select time")
    }

    fun SetTime(Hours:Int,Minute:Int){
        tvShowTime.text=Hours.toString()+":"+Minute.toString()

        val saveData=SaveData(applicationContext)
        saveData.SaveData(Hours,Minute)
        saveData.setAlarm()
    }
}