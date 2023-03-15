package com.example.bt62

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DescActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.desclayout)

        val img_desc = findViewById<ImageView>(R.id.image_desc)
        val tv_iv_desc = findViewById<TextView>(R.id.item_title)
        val tv_desc = findViewById<TextView>(R.id.item_desc1)

        val intent = intent

        val image = intent?.getIntExtra("article_image", 0)
        val titleV = intent?.getStringExtra("article_title")
        val description = intent?.getStringExtra("article_description")

        if(image != null){
            img_desc.setImageResource(image)
        }

        tv_iv_desc.text = titleV
        tv_desc.text = description

    }
}