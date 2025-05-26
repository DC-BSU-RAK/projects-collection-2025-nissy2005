package com.example.shareplate

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val displayName = findViewById<TextView>(R.id.displayName)
        val username = findViewById<TextView>(R.id.username)
        val email = findViewById<TextView>(R.id.email)

        displayName.text = "Nissy"
        username.text = "@Nissy%5"
        email.text = "nissyabrahamjoji@gmail.com"
    }
}


