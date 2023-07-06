package com.example.demorestaurant.pagesframe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.demorestaurant.R
import com.example.demorestaurant.data.AddTable
import com.google.firebase.auth.FirebaseAuth

class DatBan : Fragment(R.layout.fragment_dat_ban) {
    lateinit var auth: FirebaseAuth
    private lateinit var button1: Button
    private lateinit var button2: Button
    lateinit var intent: Intent

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        auth = FirebaseAuth.getInstance()
        val view = inflater.inflate(R.layout.fragment_dat_ban,container,false)
        button1 = view.findViewById(R.id.normal_btn)
        button2 = view.findViewById(R.id.room_btn)

        button1.setOnClickListener{
            intent = Intent(activity, AddTable::class.java)
            startActivity(intent)

        }

        button2.setOnClickListener{
            intent = Intent(activity, AddTable::class.java)
            startActivity(intent)

        }

        return view
    }
}