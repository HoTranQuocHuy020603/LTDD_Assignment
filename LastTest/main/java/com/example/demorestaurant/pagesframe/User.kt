package com.example.demorestaurant.pagesframe

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demorestaurant.ContactAdapter
import com.example.demorestaurant.R
import com.example.demorestaurant.TableAdapter
import com.example.demorestaurant.data.AddContact
import com.example.demorestaurant.data.AddTable
import com.example.demorestaurant.logandreg.Login
import com.example.demorestaurant.model.ContactModel
import com.example.demorestaurant.model.TableModel
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import de.hdodenhof.circleimageview.CircleImageView

class User : Fragment(R.layout.fragment_user){
    lateinit var auth: FirebaseAuth
    private lateinit var button1: Button
    private lateinit var button2: Button
    lateinit var intent: Intent
    lateinit var textView: TextView
    lateinit var useriv:CircleImageView
    lateinit var user : FirebaseUser
    var uri: String? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        auth = FirebaseAuth.getInstance()
        val view = inflater.inflate(R.layout.fragment_user,container,false)
        button1 = view.findViewById(R.id.add_comment_btn)
        button2 = view.findViewById(R.id.logout)
        textView = view.findViewById(R.id.user_mail_desc)
        useriv = view.findViewById(R.id.user_desc)
        user = auth.currentUser!!
        textView.setText(user.email).toString()

        useriv.setOnClickListener{
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(intent, 100)
        }
        val database = FirebaseDatabase.getInstance().reference.child("contact")
        val options = FirebaseRecyclerOptions.Builder<ContactModel>()
            .setQuery(database, ContactModel::class.java)
            .setLifecycleOwner(this)
            .build()

        val adapter = ContactAdapter(options)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv_contact)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        button1.setOnClickListener{
            intent = Intent(activity, AddContact::class.java)
            startActivity(intent)

        }

        button2.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            intent = Intent(activity, Login::class.java)
            startActivity(intent)

        }
        return view
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100){
            if(data != null){
                useriv.setImageURI(data.data)
                uri = data.data.toString()
            }
        }
    }

}