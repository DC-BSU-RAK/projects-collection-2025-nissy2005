package com.example.shareplate

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showInstructionsPopup()

        val btnAddFood = findViewById<Button>(R.id.btnAddFood)
        val btnOrderFood = findViewById<Button>(R.id.btnBrowseFood)
        val navProfile = findViewById<TextView>(R.id.navProfile)

        btnAddFood.setOnClickListener {
            val intent = Intent(this, AddFood::class.java)
            startActivity(intent)
        }

        btnOrderFood.setOnClickListener {
            val intent = Intent(this, Orders::class.java)
            startActivity(intent)
        }

        navProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showInstructionsPopup() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("👋 Welcome to SharePlate!")
        builder.setMessage(
            "Here’s how you can use the app:\n\n" +
                    "📝 Tap 'Add Food' to share extra meals.\n" +
                    "🍽️ Tap 'Order Food' to browse what others are offering.\n" +
                    "👤 Tap 'Profile' to view your details and activity.\n\n" +
                    "Let’s reduce food waste together!"
        )
        builder.setPositiveButton("Got it!") { dialog, _ -> dialog.dismiss() }
        builder.setCancelable(false)
        builder.show()
    }
}



