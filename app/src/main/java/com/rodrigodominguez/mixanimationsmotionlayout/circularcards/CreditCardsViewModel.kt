package com.rodrigodominguez.mixanimationsmotionlayout.circularcards

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class CreditCardsViewModel : ViewModel() {

    private val stream = MutableLiveData<CreditCardsModel>()

    val modelStream: LiveData<CreditCardsModel>
        get() = stream

    private val data = listOf(
        CreditCardModel(backgroundColor = Color.parseColor("#ffebee")),
        CreditCardModel(backgroundColor = Color.parseColor("#ffcdd2")),
        CreditCardModel(backgroundColor = Color.parseColor("#ef9a9a")),
        CreditCardModel(backgroundColor = Color.parseColor("#e57373")),
        CreditCardModel(backgroundColor = Color.parseColor("#ef5350")),
        CreditCardModel(backgroundColor = Color.parseColor("#f44336")),
        CreditCardModel(backgroundColor = Color.parseColor("#e53935")),
        CreditCardModel(backgroundColor = Color.parseColor("#d32f2f")),
        CreditCardModel(backgroundColor = Color.parseColor("#c62828")),
        CreditCardModel(backgroundColor = Color.parseColor("#b71c1c")),
        CreditCardModel(backgroundColor = Color.parseColor("#880e4f")),
        CreditCardModel(backgroundColor = Color.parseColor("#ad1457")),
        CreditCardModel(backgroundColor = Color.parseColor("#c2185b")),
        CreditCardModel(backgroundColor = Color.parseColor("#d81b60")),
        CreditCardModel(backgroundColor = Color.parseColor("#e91e63")),
        CreditCardModel(backgroundColor = Color.parseColor("#ec407a")),
        CreditCardModel(backgroundColor = Color.parseColor("#f06292")),
        CreditCardModel(backgroundColor = Color.parseColor("#f48fb1")),
        CreditCardModel(backgroundColor = Color.parseColor("#f8bbd0")),
        CreditCardModel(backgroundColor = Color.parseColor("#fce4ec")),

        CreditCardModel(backgroundColor = Color.parseColor("#fff8e1")),
        CreditCardModel(backgroundColor = Color.parseColor("#ffecb3")),
        CreditCardModel(backgroundColor = Color.parseColor("#ffe082")),
        CreditCardModel(backgroundColor = Color.parseColor("#ffd54f")),
        CreditCardModel(backgroundColor = Color.parseColor("#ffca28")),
        CreditCardModel(backgroundColor = Color.parseColor("#ffc107")),
        CreditCardModel(backgroundColor = Color.parseColor("#ffb300")),
        CreditCardModel(backgroundColor = Color.parseColor("#ffa000")),
        CreditCardModel(backgroundColor = Color.parseColor("#ff8f00")),
        CreditCardModel(backgroundColor = Color.parseColor("#ff6f00")),

        CreditCardModel(backgroundColor = Color.parseColor("#bf360c")),
        CreditCardModel(backgroundColor = Color.parseColor("#d84315")),
        CreditCardModel(backgroundColor = Color.parseColor("#e64a19")),
        CreditCardModel(backgroundColor = Color.parseColor("#f4511e")),
        CreditCardModel(backgroundColor = Color.parseColor("#ff5722")),
        CreditCardModel(backgroundColor = Color.parseColor("#ff7043")),
        CreditCardModel(backgroundColor = Color.parseColor("#ff8a65")),
        CreditCardModel(backgroundColor = Color.parseColor("#ffab91")),
        CreditCardModel(backgroundColor = Color.parseColor("#ffccbc")),
        CreditCardModel(backgroundColor = Color.parseColor("#fbe9e7"))
    )
    private var currentIndex = 0

    private val cardOneLeft
        get() = data[currentIndex % data.size]
    private val cardTwoLeft
        get() = data[(currentIndex + 1) % data.size]
    private val cardThreeLeft
        get() = data[(currentIndex + 2) % data.size]
    private val cardFourLeft
        get() = data[(currentIndex + 3) % data.size]
    private val cardCenter
        get() = data[(currentIndex + 4) % data.size]
    private val cardOneRight
        get() = data[(currentIndex + 5) % data.size]
    private val cardTwoRight
        get() = data[(currentIndex + 6) % data.size]
    private val cardThreeRight
        get() = data[(currentIndex + 7) % data.size]
    private val cardFourRight
        get() = data[(currentIndex + 8) % data.size]

    init {
        updateCards()
    }

    fun swipeRight() {
        currentIndex += 1
        updateCards()
    }

    fun swipeLeft() {
        if (currentIndex == 0) {
            currentIndex = data.size - 1
        } else {
            currentIndex -= 1
        }
        updateCards()
    }

    private fun updateCards() {
        stream.value = CreditCardsModel(
            cardOneLeft = cardOneLeft,
            cardTwoLeft = cardTwoLeft,
            cardThreeLeft = cardThreeLeft,
            cardFourLeft = cardFourLeft,
            cardCenter = cardCenter,
            cardOneRight = cardOneRight,
            cardTwoRight = cardTwoRight,
            cardThreeRight = cardThreeRight,
            cardFourRight = cardFourRight
        )
    }
}