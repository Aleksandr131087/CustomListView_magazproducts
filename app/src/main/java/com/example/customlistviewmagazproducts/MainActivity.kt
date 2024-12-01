package com.example.customlistviewmagazproducts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
private lateinit var namemagazTV: TextView
private lateinit var buttonCreate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

namemagazTV = findViewById(R.id.nameMagazTV)
        buttonCreate = findViewById(R.id.createMagazBTN)

        buttonCreate.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
            startActivity(intent)

        }

    }
}