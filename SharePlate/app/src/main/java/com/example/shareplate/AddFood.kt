package com.example.shareplate

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddFood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_food)

        val submitBtn = findViewById<View>(R.id.submitBtn)

        submitBtn.setOnClickListener {
            Toast.makeText(this, "Food submitted!", Toast.LENGTH_SHORT).show()
        }
    }
}

