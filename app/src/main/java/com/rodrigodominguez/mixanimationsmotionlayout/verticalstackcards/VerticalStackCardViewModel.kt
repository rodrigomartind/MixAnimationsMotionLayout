package com.rodrigodominguez.mixanimationsmotionlayout.verticalstackcards

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class VerticalStackCardViewModel: ViewModel() {

    private val stream = MutableLiveData<VerticalCardModel>()

    val modelStream: LiveData<VerticalCardModel>
        get() = stream

    private val data = listOf(
        Card(
            backgroundColor = Color.parseColor("#c50e29")
        ),
        Card(
             backgroundColor = Color.parseColor("#c60055")
        ),
        Card(
           backgroundColor = Color.parseColor("#aa00c7")
        ),
        Card(
             backgroundColor = Color.parseColor("#3f1dcb")
        ),
        Card(
             backgroundColor = Color.parseColor("#0043ca")
        ),
        Card(
            backgroundColor = Color.parseColor("#005ecb")
        ),
        Card(
             backgroundColor = Color.parseColor("#0094cc")
        ),
        Card(
             backgroundColor = Color.parseColor("#00cbcc")
        ),
        Card(
             backgroundColor = Color.parseColor("#14cba8")
        ),
        Card(
            backgroundColor = Color.parseColor("#2bbd7e")
        ),
        Card(
             backgroundColor = Color.parseColor("#7ecb20")
        ),
        Card(
            backgroundColor = Color.parseColor("#b8cc00")
        ),
        Card(
            backgroundColor = Color.parseColor("#c7cc00")
        ),
        Card(
            backgroundColor = Color.parseColor("#c8a600")
        ),
        Card(
            backgroundColor = Color.parseColor("#c77c02")
        ),
        Card(
            backgroundColor = Color.parseColor("#c53d13")
        )
    )
    private var currentIndex = 0

    private val detailCard
        get() = data[currentIndex % data.size]
    private val cardTop
        get() = data[(currentIndex + 1) % data.size]
    private val cardMiddle
        get() = data[(currentIndex + 2) % data.size]
    private val cardBottom
        get() = data[(currentIndex + 3) % data.size]
    private val cardEnd
        get() = data[(currentIndex + 4) % data.size]
    private val cardTransparent
        get() = data[(currentIndex + 5) % data.size]

    init {
        updateCards()
    }

    fun swipe() {
        currentIndex += 1
        updateCards()
    }

    private fun updateCards() {
        stream.value = VerticalCardModel(
            detailCard = detailCard,
            cardTop = cardTop,
            cardMiddle = cardMiddle,
            cardBottom = cardBottom,
            cardEnd = cardEnd,
            cardTransparent = cardTransparent
        )
    }

}