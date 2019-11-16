package com.example.yoga01

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.yogaalarm.Notifications
import com.example.yogaalarm.SaveData

class myBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.action.equals("com.tester.alarmmanager")){
            var b=intent.extras
            if (b != null) {
                //Toast.makeText(context,b.getString("message"),Toast.LENGTH_LONG).show()
                var msg=b.getString("message")
                val notifyMe= Notifications()
                notifyMe.Notify(context!!,msg.toString(),10)

            }
        }
        else if (intent!!.action.equals("android.intent.action.BOOT_COMPLETE")){

            //after reboot of phone we need to set it before that we need to save it on phone
            val saveData= SaveData(context!!)
            saveData.setAlarm()

        }
    }

}