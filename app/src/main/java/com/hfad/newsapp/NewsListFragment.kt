package com.hfad.newsapp

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

const val NEWS_HEADER_KEY = "news_header_key"
const val NEWS_AUTHOR_KEY = "news_author_key"
const val NEWS_CONTENT_KEY = "news_content_key"

class NewsListFragment : Fragment() {

    private var currentOpenNewsIndex = 0
    private val newsListSize = newsList.size - 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_list, container, false)
        val newsListLinearLayout = view.findViewById<LinearLayoutCompat>(R.id.news_list)

        for ((index, value) in newsList.withIndex()) {
            val news = TextView(activity)
            val layoutParams = LinearLayoutCompat.LayoutParams(
                LinearLayoutCompat.LayoutParams.MATCH_PARENT,
                LinearLayoutCompat.LayoutParams.WRAP_CONTENT,
            )
            layoutParams.setMargins(8, 4, 8, 4)
            news.layoutParams = layoutParams
            news.text = value.header
            news.id = index
            news.background =
                ContextCompat.getDrawable(requireContext(), R.drawable.news_text_view_shape)
            news.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))

            news.setOnClickListener {
                currentOpenNewsIndex = index
                openNews(index)
            }

            newsListLinearLayout.addView(news)
        }
        return view
    }

    private fun openNews(index: Int) {
        val news = newsList[index]
        val bundle = bundleOf(
            NEWS_HEADER_KEY to news.header,
            NEWS_AUTHOR_KEY to news.author,
            NEWS_CONTENT_KEY to news.content
        )

        parentFragmentManager.commit {
            setReorderingAllowed(true)
            addToBackStack(index.toString())
            replace<NewsContentFragment>(
                R.id.fragment_container_news_content,
                args = bundle,
                tag = "TAG:$index"
            )
        }
    }

    fun openNextNews() {
        if (currentOpenNewsIndex < newsListSize) {
            openNews(currentOpenNewsIndex + 1)
            currentOpenNewsIndex += 1
        }
    }

}