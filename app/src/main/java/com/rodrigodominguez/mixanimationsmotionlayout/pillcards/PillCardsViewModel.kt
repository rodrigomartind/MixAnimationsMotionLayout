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
            CreditCardModel(backgroundColor = Color.parseColor("#607d8b")),
            CreditCardModel(backgroundColor = Color.parseColor("#d4e157")),
            CreditCardModel(backgroundColor = Color.parseColor("#9e9e9e")),
            CreditCardModel(backgroundColor = Color.parseColor("#e91e63")),
            CreditCardModel(backgroundColor = Color.parseColor("#795548")),
            CreditCardModel(backgroundColor = Color.parseColor("#039be5")),
            CreditCardModel(backgroundColor = Color.parseColor("#fbc02d")),
            CreditCardModel(backgroundColor = Color.parseColor("#303f9f")),
            CreditCardModel(backgroundColor = Color.parseColor("#dce775")),
            CreditCardModel(backgroundColor = Color.parseColor("#6a1b9a"))
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
                cardFour = cardFourLeft)
    }
}