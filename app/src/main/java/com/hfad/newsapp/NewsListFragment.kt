package com.hfad.newsapp

import android.content.res.Configuration.ORIENTATION_PORTRAIT
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

const val TRANSACTION_NAME = "change content"

class NewsListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_list, container, false)
        val newsList = view.findViewById<LinearLayoutCompat>(R.id.news_list)

        for (i in 0 until newsList.childCount) {
            val news = newsList.getChildAt(i) as TextView
            news.setOnClickListener {
                val bundle = bundleOf(NEWS_CONTENT_HEADER_KEY to (it as TextView).text.toString())
                val orientation = resources.configuration.orientation
                val fragmentId =
                    if (orientation == ORIENTATION_PORTRAIT) R.id.fragment_container_news_list
                    else R.id.fragment_container_news_content

                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    addToBackStack(TRANSACTION_NAME)
                    replace<NewsContentFragment>(
                        fragmentId,
                        args = bundle
                    )
                }
            }
        }
        return view
    }

}