package com.example.demorestaurant.data

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.demorestaurant.MainActivity
import com.example.demorestaurant.R
import com.example.demorestaurant.logandreg.Login
import com.example.demorestaurant.model.TableModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*
import kotlin.collections.HashMap

class AddContact : AppCompatActivity() {

    private lateinit var title:EditText
    private lateinit var comment:EditText
    private lateinit var btn_add:Button
    private lateinit var btn_back:Button
    private lateinit var database:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_contact)

        title = findViewById(R.id.txt_title)
        comment = findViewById(R.id.txt_comment)

        btn_add = findViewById(R.id.add_btn)
        btn_back = findViewById(R.id.back_to_btn)

        btn_add.setOnClickListener{
            insertData()
            clearAll()
        }

        btn_back.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }

    private fun insertData() {
        val map: MutableMap<String, Any> = HashMap()
        map["title"] = title.text.toString()
        map["comment"] = comment.text.toString()
        FirebaseDatabase.getInstance().reference.child("contact")
            .push()
            .setValue(map)
            .addOnSuccessListener {
                Toast.makeText(this@AddContact, "Successfully", Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this@AddContact, "Failed", Toast.LENGTH_SHORT).show()
            }
    }

    private fun clearAll(){
        title.setText("")
        comment.setText("")
    }

}