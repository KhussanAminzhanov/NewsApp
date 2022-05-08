package com.hfad.newsapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backButton = findViewById<Button>(R.id.back_button)
        val nextButton = findViewById<Button>(R.id.next_button)

        backButton.setOnClickListener {
            supportFragmentManager.popBackStack()
        }
    }
}