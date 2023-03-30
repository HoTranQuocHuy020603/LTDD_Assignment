package com.example.bt7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = Fragment1()
        val btn2 = Fragment2()

        val fragment1btn = findViewById<Button>(R.id.fragment1_btn)
        val fragment2btn = findViewById<Button>(R.id.fragment2_btn)

        fragment1btn.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_id,btn1)
                commit()
            }
        }

        fragment2btn.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_id,btn2)
                commit()
            }
        }

    }
}