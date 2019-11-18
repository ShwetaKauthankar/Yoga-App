package com.example.yoga01

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class MyListAdapter
    (var mCtx:Context,var resource:Int,var items:List<Yoga>,val x:Int) :ArrayAdapter<Yoga>(mCtx,resource,items){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


            val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
            val view: View = layoutInflater.inflate(resource, null)

        if (x==1) {
            val imageView: ImageView = view.findViewById(R.id.imageView)
            val textView: TextView = view.findViewById(R.id.textView)

            val yoga: Yoga = items[position]


            Glide.with(mCtx)
                .load(yoga.image)
                .into(imageView)


            textView.text = yoga.name
        }
        else{
            val imageView: ImageView = view.findViewById(R.id.imgV)
            val textViewName: TextView = view.findViewById(R.id.poseName)
            val textViewDes: TextView = view.findViewById(R.id.txtdescp)

            val yoga: Yoga = items[position]


            Glide.with(mCtx)
                .load(yoga.image)
                .into(imageView)


            textViewName.text = yoga.name
            textViewDes.text = yoga.description
        }
        return view




    }
}


