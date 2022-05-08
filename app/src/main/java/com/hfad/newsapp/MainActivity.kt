package com.hfad.newsapp

import android.content.res.Configuration
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
            if (supportFragmentManager.backStackEntryCount == 1) {
                newsListFragment.changeTextViewAppearance(
                    newsListFragment.currentOpenNewsIndex,
                    R.drawable.text_view_def,
                    R.color.black
                )
                newsListFragment.currentOpenNewsIndex = -1
            } else {
                setToPreviousNewsIndex()
            }
        }
        nextButton.setOnClickListener { newsListFragment.openNextNews() }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {
            newsListFragment.changeTextViewAppearance(
                newsListFragment.currentOpenNewsIndex,
                R.drawable.text_view_def,
                R.color.black
            )
            newsListFragment.currentOpenNewsIndex = -1
        } else {
            setToPreviousNewsIndex()
        }
    }

    private fun setToPreviousNewsIndex() {
        if (newsListFragment.currentOpenNewsIndex >= 0) {
            newsListFragment.changeTextViewAppearance(
                newsListFragment.currentOpenNewsIndex,
                R.drawable.text_view_def,
                R.color.black
            )
            newsListFragment.changeTextViewAppearance(
                newsListFragment.currentOpenNewsIndex - 1,
                R.drawable.text_view_selected,
                R.color.white
            )
            newsListFragment.currentOpenNewsIndex -= 1
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(CURRENT_NEWS_INDEX, newsListFragment.currentOpenNewsIndex)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        newsListFragment.currentOpenNewsIndex = savedInstanceState.getInt(CURRENT_NEWS_INDEX)
        newsListFragment.changeTextViewAppearance(
            newsListFragment.currentOpenNewsIndex,
            R.drawable.text_view_selected,
            R.color.white
        )
    }
}