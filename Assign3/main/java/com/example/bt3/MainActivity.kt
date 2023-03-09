package com.example.bt3

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlin.Boolean as Boolean

class MainActivity : AppCompatActivity() {

    lateinit var selectionGroup: RadioGroup
    lateinit var exTV: TextView
    lateinit var exIV: ImageView
    lateinit var hideImage: Switch

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.assiment1)
        selectionGroup = findViewById(R.id.nextImg)
        exTV = findViewById(R.id.textView)
        exIV = findViewById(R.id.image1)
        selectionGroup.setOnCheckedChangeListener { _, checkedID ->
            when (checkedID) {
                R.id.img1 -> {
                    exTV.text = "Đây là 1"
                    exIV.setImageResource(R.drawable.image1)
                }
                R.id.img2 -> {
                    exTV.text = "Đây là 2"
                    exIV.setImageResource(R.drawable.image2)
                }
                R.id.img3 -> {
                    exTV.text = "Đây là 3"
                    exIV.setImageResource(R.drawable.image3)
                }
                R.id.img4 -> {
                    exTV.text = "Đây là 4"
                    exIV.setImageResource(R.drawable.image4)
                }

            }
        }
        hideImage = findViewById(R.id.switch1)
        hideImage.setOnCheckedChangeListener { _, checked ->
            if (checked) {
                exIV.visibility = ImageView.INVISIBLE
            } else {
                exIV.visibility = ImageView.VISIBLE
            }
            val contextMenuBtn = findViewById<Button>(R.id.menuBtn)
            registerForContextMenu(contextMenuBtn)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menuShow -> {
                selectionGroup.visibility = RadioGroup.VISIBLE
                exIV.visibility = TextView.VISIBLE
                exIV.visibility = ImageView.VISIBLE
                hideImage.visibility = Switch.VISIBLE
            }
            R.id.menuHide -> {
                selectionGroup.visibility = RadioGroup.INVISIBLE
                exTV.visibility = TextView.INVISIBLE
                exIV.visibility = ImageView.INVISIBLE
                hideImage.visibility = Switch.INVISIBLE
            }
        }
        return super.onOptionsItemSelected(item)

    }

    override fun onCreateContextMenu(menu: ContextMenu?,v: View?,menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu?.setHeaderTitle("Chose An Active")
        menu?.add(0, v!!.id, 0, "SHOW")
        menu?.add(0, v!!.id, 0, "HIDE")
    }


    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.title) {
            "SHOW" -> {
                selectionGroup.visibility = RadioGroup.VISIBLE
                exIV.visibility = TextView.VISIBLE
                exIV.visibility = ImageView.VISIBLE
                hideImage.visibility = Switch.VISIBLE
            }
            "HIDE" -> {
                selectionGroup.visibility = RadioGroup.INVISIBLE
                exTV.visibility = TextView.INVISIBLE
                exIV.visibility = ImageView.INVISIBLE
                hideImage.visibility = Switch.INVISIBLE
            }
        }
        return super.onContextItemSelected(item)
    }
}