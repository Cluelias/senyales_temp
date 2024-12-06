package com.example.fsltalk

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    // Firebase authentication instance
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Initialize views
        val etFullName: EditText = findViewById(R.id.etFullName)
        val etEmail: EditText = findViewById(R.id.etEmail)
        val etPassword: EditText = findViewById(R.id.etPassword)
        val etConfirmPassword: EditText = findViewById(R.id.etConfirmPassword)
        val btnSignUp: Button = findViewById(R.id.btnSignUp)
        val tvLogin: TextView = findViewById(R.id.tvLogin)

        // Set up Sign-Up button click event
        btnSignUp.setOnClickListener {
            val fullName = etFullName.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            when {
                fullName.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() -> {
                    Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                }
                password != confirmPassword -> {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    Toast.makeText(this, "Sign-Up Successful!", Toast.LENGTH_SHORT).show()
                    // Add functionality to save data here
                }
            }
        }

        // Redirect to Login screen
        tvLogin.setOnClickListener {
            Toast.makeText(this, "Redirecting to Login...", Toast.LENGTH_SHORT).show()
            // Add Intent to navigate to Login Activity here
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