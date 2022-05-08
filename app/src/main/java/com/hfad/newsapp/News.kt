package com.hfad.newsapp

data class News(val header: String, val author: String, val content: String)

val newsList = arrayListOf<News>(
    News(
        "Unauthorized gem takeover for some gems",
        "laursisask",
        "Due to a bug in the yank action, it was possible for any RubyGems.org user to remove and replace certain gems even if that user was not authorized to do so."
    ),
    News(
        "Web Development for Beginners – A Curriculum",
        "microsoft (github.com)",
        "Azure Cloud Advocates at Microsoft are pleased to offer a 12-week, 24-lesson curriculum all about JavaScript, CSS, and HTML basics. Each lesson includes pre- and post-lesson quizzes, written instructions to complete the lesson, a solution, an assignment and more. Our project-based pedagogy allows you to learn while building, a proven way for new skills to 'stick'."
    ),
    News(
        "When Buying the Dip Doesn’t Work: An Analysis of the Dot-Com Crash",
        "Luke M. (Endless Metrics)",
        "Since March 6, 2009, when the S&P 500 hit its low point during the Great Recession, one investing strategy has reigned supreme: buying the dip."
    ),
    News(
        "Xilem: an architecture for UI in Rust",
        "Raph Levien",
        "Rust is an appealing language for building user interfaces for a variety of reasons, especially the promise of delivering both performance and safety. However, finding a good architecture is challenging. Architectures that work well in other languages generally don’t adapt well to Rust, mostly because they rely on shared mutable state and that is not idiomatic Rust, to put it mildly."
    ),
    News(
        "Some CUDA programming fun with Julia",
        "Can Candan (github.com)",
        "Suppose we want to draw a batch of images, where each image is made up of randomly positioned and colored triangles, that are blending. It will look like this: triangles and then find the euclidean distance of each such image to a given target image. Now why on earth am I doing this? Well, this turns into an interesting optimization problem of finding the closest triangle image and also an excuse to practise Julia. The inspiration is from the this repo based on EvoJax."
    ),
    News(
        "New Assembly Like Programming Language?",
        "Tristan Wellman",
        "This is a small project made by yours truly (TristanWellman). This language includes your normal things like variables, mathematics, loops, etc. It compiles directly to assembly(NASM), See below for compilation and simple documentation."
    )
)