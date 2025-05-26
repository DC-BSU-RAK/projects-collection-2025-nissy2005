package com.example.drawfusionnancalculator

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var categorySpinner1: Spinner
    private lateinit var categorySpinner2: Spinner
    private lateinit var drawFusionButton: Button
    private lateinit var instructionsButton: Button
    private lateinit var backButton: Button
    private lateinit var fusionImage: ImageView
    private lateinit var homeView: LinearLayout
    private lateinit var drawView: LinearLayout

    private val birds = listOf("Eagle", "Parrot", "Swan", "Peacock")
    private val flowers = listOf("Sunflower", "Rose", "Tulip", "Lily")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        categorySpinner1 = findViewById(R.id.categorySpinner1)
        categorySpinner2 = findViewById(R.id.categorySpinner2)
        drawFusionButton = findViewById(R.id.drawFusionButton)
        instructionsButton = findViewById(R.id.instructionsButton)
        backButton = findViewById(R.id.backButton)
        fusionImage = findViewById(R.id.fusionImage)
        homeView = findViewById(R.id.homeView)
        drawView = findViewById(R.id.drawView)
        
        categorySpinner1.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, birds)
        categorySpinner2.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, flowers)

        drawFusionButton.setOnClickListener {
            val bird = categorySpinner1.selectedItem.toString().lowercase()
            val flower = categorySpinner2.selectedItem.toString().lowercase()
            val fusionName = "${bird}_${flower}"

            val resId = resources.getIdentifier(fusionName, "drawable", packageName)
            if (resId != 0) {
                fusionImage.setImageResource(resId)
            } else {
                Toast.makeText(this, "No fusion image available for this combination", Toast.LENGTH_SHORT).show()
                fusionImage.setImageResource(0) // Clear image
            }

            homeView.visibility = LinearLayout.GONE
            drawView.visibility = LinearLayout.VISIBLE
        }

        backButton.setOnClickListener {
            drawView.visibility = LinearLayout.GONE
            homeView.visibility = LinearLayout.VISIBLE
        }

        instructionsButton.setOnClickListener {
            val instructions = """
                🟠 How to use DrawFusion:
                
                1. Select a bird from the first dropdown.
                2. Select a flower from the second dropdown.
                3. Tap "Show Fusion" to see the combination image.
                4. Tap "Back" to try another combination.
            """.trimIndent()

            AlertDialog.Builder(this)
                .setTitle("Instructions")
                .setMessage(instructions)
                .setPositiveButton("Got it!") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}