package com.hfad.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

const val NEWS_CONTENT_HEADER_KEY = "news_content_header_key"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}