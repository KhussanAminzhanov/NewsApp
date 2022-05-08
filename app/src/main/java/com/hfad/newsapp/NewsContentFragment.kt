package com.hfad.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NewsContentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news_content, container, false)
        val header = view.findViewById<TextView>(R.id.header)
        val author = view.findViewById<TextView>(R.id.author)
        val content = view.findViewById<TextView>(R.id.content)

        header.text = requireArguments().getString(NEWS_HEADER_KEY)
        author.text = getString(R.string.author, requireArguments().getString(NEWS_AUTHOR_KEY))
        content.text = requireArguments().getString(NEWS_CONTENT_KEY)

        return view
    }

}