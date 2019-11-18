package com.example.yoga01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import java.net.URL

class MainActivity : AppCompatActivity() {

    lateinit var listview: ListView
    lateinit var btnStartSession:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        listview=findViewById(R.id.listView)
        btnStartSession=findViewById(R.id.btnStartSession)
        var list= mutableListOf<Yoga>()

        var  category = intent.getStringExtra("label")
// code which has been changed
        val db = FirebaseFirestore.getInstance()
        db.collection("yoga-exercise")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("main==>", "${document.id} => ${document.data}")
                    if(document.data.get("category").toString()==category) {
                        list.add(
                            Yoga(
                                document.data.get("pose").toString(),
                                document.data.get("name").toString(),
                                document.data.get("description").toString()

                            )
                        )
                    }

                }
                /////code
                val adpater:MyListAdapter= MyListAdapter(this,R.layout.my_list_iteam,list,1)
                listview.adapter=adpater

                listview.setOnItemClickListener{ adapterView, view, i, l ->


                    var intent = Intent(this,viewClickedActivity::class.java)
                    intent.putExtra("name",list[i])
                    startActivity(intent)

                }




            }
            .addOnFailureListener { exception ->
                Log.w("man==>", "Error getting documents.", exception)
            }


        btnStartSession.setOnClickListener {

            var intent = Intent(this,startSession::class.java)
            startActivity(intent)
        }



    }
}


