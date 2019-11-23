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
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


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
        val type:String
        val calendar = Calendar.getInstance()
        val day = calendar.get(Calendar.DAY_OF_WEEK)
        Log.d("===>", "day data: ${day}")
        val daysArray =
            arrayOf<String>("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

        val dayname=daysArray[day-1]
        if(category=="Beginner"){
            type="B"
        }
        else if(category=="intermediate"){
            type="I"
        }
        else{
            type="E"
        }
// code which has been changed
        val db = FirebaseFirestore.getInstance()



       //===============================new code===========================

        val documenttype:String
        documenttype=dayname+"-"+type
        Log.d("===>", "day data: ${documenttype}")
        val docRef = db.collection("day").document(documenttype)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("===>", "DocumentSnapshot data: ${document.data}")
                    val element:String = document.data?.get("exercise").toString()
                    Log.d("===>", "element data: ${element}")
                    var exe:List<String> = element.substring(1,element.length-1).split("\\s*,\\s*")
                    Log.d("===>", "exe: ${exe[0]}")
                    var value:Array<String>
                    value=subStr(exe[0])


                    for(pose in value){
                        Log.d("===>", "element data: ${pose}")

                            val docRef = db.collection("yoga-exercise").document(pose)
                            docRef.get()
                                .addOnSuccessListener { document ->
                                    if (document != null) {

                                        list.add(
                                            Yoga(
                                                document.data?.get("pose").toString(),
                                                document.data?.get("name").toString(),
                                                document.data?.get("description").toString()

                                            )
                                        )

                                        val adpater:MyListAdapter= MyListAdapter(this,R.layout.my_list_iteam,list,1)
                                        listview.adapter=adpater

                                        listview.setOnItemClickListener{ adapterView, view, i, l ->


                                            var intent = Intent(this,viewClickedActivity::class.java)
                                            intent.putExtra("name",list[i])
                                            startActivity(intent)

                                        }


                                    } else {
                                        Log.d("==>", "No such document")
                                    }
                                }
                                .addOnFailureListener { exception ->
                                    Log.d("==>", "get failed with ", exception)
                                }

                    }

                    progressBar3.visibility=View.GONE

                } else {
                    Log.d("===>", "No such document")
                }


            }
            .addOnFailureListener { exception ->
                Log.d("===>", "get failed with ", exception)
            }




        //===============================new code===========================

        btnStartSession.setOnClickListener {

            var intent = Intent(this,startSession::class.java)
            startActivity(intent)
        }



    }


    fun subStr(exe:String): Array<String> {

        val arrOfStr = exe.split(", ".toRegex(), 10).toTypedArray()

        return arrOfStr
    }

}


