package com.example.demorestaurant

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.demorestaurant.model.ContactModel
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.Holder
import com.orhanobut.dialogplus.ViewHolder

class ContactAdapter(options: FirebaseRecyclerOptions<ContactModel>):
    FirebaseRecyclerAdapter<ContactModel, ContactAdapter.ViewHolder>(options) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.usercontact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, model: ContactModel) {
        holder.bind(model)
        holder.editbtn.setOnClickListener {
            val dialogPlus = DialogPlus.newDialog(holder.title.context)
                .setContentHolder(ViewHolder(R.layout.update_popup))
                .setExpanded(true, 1200)
                .create()

            val view: View = dialogPlus.holderView

            val title: EditText = view.findViewById(R.id.txt_title)
            val comment: EditText = view.findViewById(R.id.txt_comment)

            val btnSave: Button = view.findViewById(R.id.edit_btn)

            title.setText(model.title)
            comment.setText(model.title)

            dialogPlus.show()

            btnSave.setOnClickListener {
                val map: MutableMap<String, Any> = HashMap()
                map["title"] = title.text.toString()
                map["comment"] = comment.text.toString()
                FirebaseDatabase.getInstance().reference.child("contact")
                    .child(getRef(position).getKey()!!).updateChildren(map)
                    .addOnSuccessListener {
                        dialogPlus.dismiss()
                    }.addOnFailureListener {
                        dialogPlus.dismiss()
                    }
            }
        }
        holder.delbtn.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(holder.title.context)
            builder.setTitle("Are you sure?")
            builder.setTitle("Delete cant be undo.")

            builder.setPositiveButton("Delete") { dialog, which ->
                FirebaseDatabase.getInstance().reference.child("contact")
                    .child(getRef(position).getKey()!!).removeValue()

            }
            builder.setNegativeButton("Cancel") { dialog, which ->
                Toast.makeText(holder.title.context, "Cancelled", Toast.LENGTH_SHORT).show()
            }
            builder.show()

        }
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.title_txt)
        private val comment = itemView.findViewById<TextView>(R.id.comment_txt)
        val editbtn = itemView.findViewById<Button>(R.id.btn_edit)
        val delbtn = itemView.findViewById<Button>(R.id.btn_del)

        fun bind(item: ContactModel) {
            title.text = item.title
            comment.text = item.comment

        }
    }
    }
