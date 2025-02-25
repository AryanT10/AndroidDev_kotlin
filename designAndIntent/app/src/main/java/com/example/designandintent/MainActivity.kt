package com.example.designandintent
/*
 * -----------------------------------------------------------
 * Name: Aryan Tuwar
 * Subject: MAP244
 * Section: NSC
 * Student ID: 112137229
 *
 * This code is created solely for academic purposes as part
 * of the MAP244 course. Any resemblance to other works is
 * purely coincidental, and no copyrighted material has been
 * used without proper attribution.
 * -----------------------------------------------------------
 */



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Declare button
        val btnGoToHomePage = findViewById<Button>(R.id.btnHomePage)


        // Button on click listener
        btnGoToHomePage.setOnClickListener {
            val openRegistrationActivity = Intent(this, RegistrationActivity::class.java)
            startActivity(openRegistrationActivity)
        }

    }
}