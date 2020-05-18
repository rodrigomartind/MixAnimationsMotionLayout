package com.rodrigodominguez.mixanimationsmotionlayout.storiesinstagram

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class StoriesViewModel: ViewModel() {

    private val stream = MutableLiveData<StoryModel>()

    val modelStream: LiveData<StoryModel>
        get() = stream

    private val data = listOf(
        Story(
            backgroundColor = Color.parseColor("#4b636e")
        ),
        Story(
             backgroundColor = Color.parseColor("#c56200")
        ),
        Story(
           backgroundColor = Color.parseColor("#c79400")
        ),
        Story(
             backgroundColor = Color.parseColor("#c7b800")
        ),
        Story(
             backgroundColor = Color.parseColor("#90cc00")
        ),
        Story(
            backgroundColor = Color.parseColor("#32cb00")
        ),
        Story(
             backgroundColor = Color.parseColor("#00b248")
        ),
        Story(
             backgroundColor = Color.parseColor("#00b686")
        ),
        Story(
             backgroundColor = Color.parseColor("#00b2cc")
        ),
        Story(
            backgroundColor = Color.parseColor("#0081cb")
        ),
        Story(
             backgroundColor = Color.parseColor("#004ecb")
        ),
        Story(
            backgroundColor = Color.parseColor("#0031ca")
        ),
        Story(
            backgroundColor = Color.parseColor("#0100ca")
        )
    )
    private var currentIndex = 0

    private val topCard
        get() = data[currentIndex % data.size]
    private val bottomCard
        get() = data[(currentIndex + 1) % data.size]

    init {
        updateCards()
    }

    fun swipe() {
        currentIndex += 1
        updateCards()
    }

    private fun updateCards() {
        stream.value = StoryModel(
            cardTop = topCard,
            cardBottom = bottomCard
        )
    }

}