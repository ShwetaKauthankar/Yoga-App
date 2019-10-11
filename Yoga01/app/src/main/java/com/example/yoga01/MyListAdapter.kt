package com.example.yoga01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyListAdapter
    (var mCtx:Context,var resource:Int,var items:List<Yoga>) :ArrayAdapter<Yoga>(mCtx,resource,items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater:LayoutInflater= LayoutInflater.from(mCtx)
        val view:View=layoutInflater.inflate(resource,null)
        val imageView:ImageView=view.findViewById(R.id.imageView)
        val textView:TextView=view.findViewById(R.id.textView)

        val yoga:Yoga=items[position]

        imageView.setImageDrawable(mCtx.resources.getDrawable(yoga.image))
        textView.text=yoga.name

        return view
    }
}