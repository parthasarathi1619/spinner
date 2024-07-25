package com.example.spinner_task

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.security.AccessController.getContext

class MainActivity : AppCompatActivity(), OnItemSelectedListener {
    var color= arrayOf("RED","green","blue","yellow")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        spinner.onItemSelectedListener = this
        if (spinner != null)
        {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, color)
            spinner.adapter=adapter
        }

    }
    override fun onItemSelected(parent: AdapterView<*>?,
                                view: View, position: Int,
                                id: Long) {
        val selectedColor = when (position) {
            0 -> Color.RED
            1 -> Color.GREEN
            2 -> Color.BLUE
            3 -> Color.YELLOW
            else -> Color.WHITE // Default color
        }
        findViewById<View>(R.id.bgview).setBackgroundColor(selectedColor)
//        cardView.setBackgroundColor(ContextCompat.getColor(this, R.color.my_color));

        Log.d("find","done")
        // make toast of name of course
        // which is selected in spinner
        Toast.makeText(applicationContext,
            color[position],
            Toast.LENGTH_LONG)
            .show()
        var c = color[position].toString()
        Log.d("find",c)


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}







