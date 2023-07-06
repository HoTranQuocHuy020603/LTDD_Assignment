package com.example.demorestaurant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import com.example.demorestaurant.logandreg.Login
import com.example.demorestaurant.pagesframe.DatBan
import com.example.demorestaurant.pagesframe.Home
import com.example.demorestaurant.pagesframe.ThongTinDat
import com.example.demorestaurant.pagesframe.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var user : FirebaseUser
    lateinit var framelog : FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        framelog = findViewById(R.id.framelog)

        //for login
        auth = FirebaseAuth.getInstance()
        user = auth.currentUser!!
        if( user == null){
            intent = Intent(applicationContext, Login::class.java)
            startActivity(intent)
            finish()
        }

        //for frame
        val btn1 = Home()
        val btn2 = DatBan()
        val btn3 = ThongTinDat()
        val btn4 = User()

        val fragment1btn = findViewById<Button>(R.id.home_btn)
        val fragment2btn = findViewById<Button>(R.id.datban_btn)
        val fragment3btn = findViewById<Button>(R.id.thongtindat_btn)
        val fragment4btn = findViewById<Button>(R.id.user_btn)

        fragment1btn.setOnClickListener{
            framelog.visibility = View.GONE
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_id,btn1)
                commit()
            }
        }

        fragment2btn.setOnClickListener{
            framelog.visibility = View.GONE
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_id,btn2)
                commit()
            }
        }

        fragment3btn.setOnClickListener{
            framelog.visibility = View.GONE
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_id,btn3)
                commit()
            }
        }

        fragment4btn.setOnClickListener{
            framelog.visibility = View.GONE
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment_id,btn4)
                commit()
            }
        }

    }
}