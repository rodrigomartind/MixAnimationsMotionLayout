package com.rodrigodominguez.mixanimationsmotionlayout.pillcards

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.rodrigodominguez.mixanimationsmotionlayout.circularcards.CreditCardModel

class PillCardsViewModel : ViewModel() {

    private val stream = MutableLiveData<PillCardModel>()

    val modelStream: LiveData<PillCardModel>
        get() = stream

    private val data = listOf(
            CreditCardModel(backgroundColor = Color.parseColor("#ffcdd2")),
            CreditCardModel(backgroundColor = Color.parseColor("#ad1457")),
            CreditCardModel(backgroundColor = Color.parseColor("#e1bee7")),
            CreditCardModel(backgroundColor = Color.parseColor("#4527a0")),
            CreditCardModel(backgroundColor = Color.parseColor("#c5cae9")),
            CreditCardModel(backgroundColor = Color.parseColor("#00838f")),
            CreditCardModel(backgroundColor = Color.parseColor("#dcedc8")),
            CreditCardModel(backgroundColor = Color.parseColor("#9e9d24")),
            CreditCardModel(backgroundColor = Color.parseColor("#fff59d")),
            CreditCardModel(backgroundColor = Color.parseColor("#388e3c")),
            CreditCardModel(backgroundColor = Color.parseColor("#689f38"))
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
    private val cardFive
        get() = data[(currentIndex + 4) % data.size]


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
        stream.value = PillCardModel(
                cardOne = cardOneLeft,
                cardTwo = cardTwoLeft,
                cardThree = cardThreeLeft,
                cardFour = cardFourLeft,
                cardFive = cardFive)
    }
}