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


package com.example.designandintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThankYouActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_thank_you)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.thankyou)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find the TextView for the thank-you message
        val thankYouMessage = findViewById<TextView>(R.id.tvThankYou)
        val btnGoToHomePage = findViewById<Button>(R.id.btnHomePage2)

        // Retrieve the first name from the Intent
        val firstName = intent.getStringExtra("FIRST_NAME") ?: "User"

        // Display the message
        thankYouMessage.text = getString(R.string.thank_you_message, firstName)

        // Button on click listener
        btnGoToHomePage.setOnClickListener {
            val openRegistrationActivity = Intent(this, RegistrationActivity::class.java)
            startActivity(openRegistrationActivity)
        }
    }

}