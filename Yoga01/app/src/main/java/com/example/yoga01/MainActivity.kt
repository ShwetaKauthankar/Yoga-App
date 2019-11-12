package com.example.yoga01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var listview: ListView
    lateinit var btnStartSession:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listview=findViewById(R.id.listView)
        btnStartSession=findViewById(R.id.btnStartSession)
        var list= mutableListOf<Yoga>()
        list.add(Yoga(R.drawable.mountain,"mountain"))
        list.add(Yoga(R.drawable.downward,"downward"))
        list.add(Yoga(R.drawable.plank,"plank"))




        val adpater:MyListAdapter= MyListAdapter(this,R.layout.my_list_iteam,list)
        listview.adapter=adpater

        listview.setOnItemClickListener{ adapterView, view, i, l ->


            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra("name",list[i])
            startActivity(intent)

        }

        btnStartSession.setOnClickListener {

            var intent = Intent(this,startSession::class.java)
            startActivity(intent)
        }



    }
}


