package com.hfad.newsapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val newsListFragment: NewsListFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fragment_container_news_list) as NewsListFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val backButton = findViewById<Button>(R.id.back_button)
        val nextButton = findViewById<Button>(R.id.next_button)

        backButton.setOnClickListener {
            supportFragmentManager.popBackStack()
            setToPreviousNewsIndex()
        }
        nextButton.setOnClickListener { newsListFragment.openNextNews() }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        setToPreviousNewsIndex()
    }

    private fun setToPreviousNewsIndex() {
        if (newsListFragment.currentOpenNewsIndex >= 0) {
            newsListFragment.changeTextViewAppearance(newsListFragment.currentOpenNewsIndex, R.drawable.text_view_def, R.color.black)
            newsListFragment.changeTextViewAppearance(newsListFragment.currentOpenNewsIndex - 1, R.drawable.text_view_selected, R.color.white)
            newsListFragment.currentOpenNewsIndex -= 1
        }
    }
}