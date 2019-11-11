package com.example.yoga01

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_list_iteam.*
import kotlinx.android.synthetic.main.view_clicked_activity.*

class viewClickedActivity: AppCompatActivity() {

    lateinit var listview: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.view_clicked_activity)


        listview=findViewById(R.id.listViewClick)
        var list= mutableListOf<Yoga>()
            list.add(intent.getSerializableExtra("name")as Yoga)

        val adpater:MyListAdapter= MyListAdapter(this,R.layout.my_list_iteam,list)
        listview.adapter=adpater


    }

}

