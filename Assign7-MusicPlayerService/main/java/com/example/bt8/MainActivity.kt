package com.example.bt8

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {
    private var btn : Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val playbutton = findViewById<Button>(R.id.play_btn)
        val imageView = findViewById<ImageView>(R.id.img_iv)
        playbutton.setOnClickListener(){
            val play =  Intent(this@MainActivity,
                MusicService::class.java)
            startService(play)

            if (btn === true)
            {
                Glide.with(this).load(R.drawable.play)
                .into(imageView)
                playbutton.text = "Pause"
                btn = false
            }
            else
            {
                Glide.with(this).load(R.drawable.pause)
                    .into(imageView)
                playbutton.text = "Play"
                btn = true
            }

        }
        findViewById<Button>(R.id.stop_btn).setOnClickListener(){
            if (playbutton.text == "Pause") {
                Glide.with(this).load(R.drawable.stop)
                    .into(imageView)
                val stop = Intent(this@MainActivity,
                    MusicService::class.java)
                playbutton.text = "Play"
                btn = true
                startService(stop)
            }
            else
                Glide.with(this).load(R.drawable.stop)
                    .into(imageView)

        }
    }
}
