package com.example.newsapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_two)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        // Get the passed user name from Intent
        val userName = intent.getStringExtra("userName") ?: "User"

        // Set the welcome message
        val welcomeMessage = findViewById<TextView>(R.id.welcomeMessage)
        // getStringExtra("userName") extracts the data from the Bundle passed with the Intent.
        welcomeMessage.text = getString(R.string.welcome_message, userName)
    }
}