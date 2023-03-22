package com.example.testingurl2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import com.example.testingurl2.R
import com.squareup.picasso.Picasso

class DescActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.desclayout)

    //    val tv_iv_title = findViewById<TextView>(R.id.item_title)
        val img_desc = findViewById<ImageView>(R.id.image_desc)
        val tv_iv_desc = findViewById<TextView>(R.id.item_desc1)

        val intent = intent

        val image = intent?.getStringExtra("name")
        val titleV = intent?.getStringExtra("description")

        if(image != null){
            Picasso.get().load(image).into(img_desc)
        }

        tv_iv_desc.text = titleV
    }
}