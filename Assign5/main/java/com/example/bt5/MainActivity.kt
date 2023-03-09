package com.example.bt5

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @Suppress("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.login_button).setOnClickListener {
            val username = findViewById<TextView>(R.id.login_username_tv).text.toString().trim()
            val password = findViewById<TextView>(R.id.login_password_tv).text.toString().trim()
            if (username == "admin" || username == "Huy" || username == "UED" && password == "123") {
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                intent.putExtra("user", username)
                startActivity(intent)
                startActivityForResult(intent, 100)
            } else {
                Toast.makeText(this@MainActivity, "Login Failed", Toast.LENGTH_LONG).show()
            }

        }
//        val loginImg = findViewById<ImageView>(R.id.login_image_iv)
//        val intent = intent
//        val uri: Uri? =  intent.getParcelableExtra("image")
//        loginImg.setImageURI(uri)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100){
            if(data != null){
                val imageURLString = data.getStringExtra("image")
                val uri = Uri.parse(imageURLString)
                findViewById<ImageView>(R.id.home_image_iv).setImageURI(uri)
            }
        }
    }
}
