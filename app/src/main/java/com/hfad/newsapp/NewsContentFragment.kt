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
        val hintMessage = view.findViewById<TextView>(R.id.hint_message)
        val someText = requireArguments().getString(NEWS_CONTENT_HEADER_KEY)
        hintMessage.text = someText
        return view
    }

}