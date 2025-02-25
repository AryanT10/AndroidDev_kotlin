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
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registration)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.registration)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find views by their IDs
        val firstNameField = findViewById<EditText>(R.id.etFirstName)
        val registerButton = findViewById<Button>(R.id.btnRegister)

        // Set up the button click listener
        registerButton.setOnClickListener {
            // Get the input from the first name field
            val firstName = firstNameField.text.toString().trim()

            // Check if the first name is not empty
                // Pass the first name to the ThankYouActivity
//                val intent = Intent(this, ThankYouActivity::class.java)
//                intent.putExtra("FIRST_NAME", firstName) // Pass the first name
//                startActivity(intent)

            if (firstName.isNotEmpty()) {
                // Create an intent to navigate to ThankYouActivity
                val intent = Intent(this, ThankYouActivity::class.java)
                intent.putExtra("FIRST_NAME", firstName) // Pass the first name
                startActivity(intent)
            } else {
                // Show an error message if the first name is empty
                Toast.makeText(this, "Please enter your first name", Toast.LENGTH_SHORT).show()
            }
        }
    }
}