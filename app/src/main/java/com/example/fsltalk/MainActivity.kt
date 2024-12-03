package com.example.fsltalk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ensure that the layout is correctly loaded and the button exists
        val usernameInput = findViewById<EditText>(R.id.usernameInput)
        val passwordInput = findViewById<EditText>(R.id.passwordInput)
        val loginButton = findViewById<Button>(R.id.loginButton) // Make sure this ID exists in your layout
        val linkToSignUp = findViewById<TextView>(R.id.linkToSignUp)

        // Check if the button is null to avoid a NullPointerException
        if (loginButton != null) {
            loginButton.setOnClickListener {
                val username = usernameInput.text.toString()
                val password = passwordInput.text.toString()

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
                } else {
                    // Transition to homepage
                    val intent = Intent(this, HomePageActivity::class.java)
                    startActivity(intent)
                    finish() // Close MainActivity to prevent going back on back press
                }
            }
        }

        // Check if the linkToSignUp TextView is valid before setting the click listener
        linkToSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
