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
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    // Firebase authentication instance
    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

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

// Firebase authentication for login
    //auth.signInWithEmailAndPassword(email, password)
    //.addOnCompleteListener(this) { task ->
    //    if (task.isSuccessful) {
    //        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
    //        // Redirect to the main activity
    //        startActivity(Intent(this, MainActivity::class.java))
    //        finish()
    //    } else {
    //        Toast.makeText(this, "Login Failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
    //    }
    //}
