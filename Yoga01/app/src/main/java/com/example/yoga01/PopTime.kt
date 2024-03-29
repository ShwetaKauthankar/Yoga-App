package com.example.yoga01

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment

class PopTime:DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var myView=inflater!!.inflate(R.layout.pop_time,container,false)
        var buDone=myView.findViewById(R.id.buDone) as Button
        var tp1=myView.findViewById(R.id.tp1)as TimePicker

        buDone.setOnClickListener({
             val ma=activity as Alarm
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                ma.SetTime(tp1.hour,tp1.minute)
            }else{
                ma.SetTime(tp1.currentHour,tp1.currentMinute)
            }
            this.dismiss()
        })
        return myView
    }
}