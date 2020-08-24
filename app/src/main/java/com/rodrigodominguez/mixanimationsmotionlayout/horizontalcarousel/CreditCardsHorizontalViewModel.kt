package com.rodrigodominguez.mixanimationsmotionlayout.horizontalcarousel

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import com.rodrigodominguez.mixanimationsmotionlayout.circularcards.CreditCardModel

class CreditCardsHorizontalViewModel : ViewModel() {

    private val stream = MutableLiveData<CreditCardsHorizontalModel>()

    val modelStream: LiveData<CreditCardsHorizontalModel>
        get() = stream

    private val data = listOf(
            CreditCardModel(backgroundColor = Color.parseColor("#d32f2f")),
            CreditCardModel(backgroundColor = Color.parseColor("#c2185b")),
            CreditCardModel(backgroundColor = Color.parseColor("#7b1fa2")),
            CreditCardModel(backgroundColor = Color.parseColor("#512da8")),
            CreditCardModel(backgroundColor = Color.parseColor("#303f9f")),
            CreditCardModel(backgroundColor = Color.parseColor("#1976d2")),
            CreditCardModel(backgroundColor = Color.parseColor("#0288d1")),
            CreditCardModel(backgroundColor = Color.parseColor("#0097a7")),
            CreditCardModel(backgroundColor = Color.parseColor("#00796b")),
            CreditCardModel(backgroundColor = Color.parseColor("#388e3c")),
            CreditCardModel(backgroundColor = Color.parseColor("#689f38")),
            CreditCardModel(backgroundColor = Color.parseColor("#afb42b")),
            CreditCardModel(backgroundColor = Color.parseColor("#fbc02d")),
            CreditCardModel(backgroundColor = Color.parseColor("#ffa000")),
            CreditCardModel(backgroundColor = Color.parseColor("#f57c00")),
            CreditCardModel(backgroundColor = Color.parseColor("#e64a19")),
            CreditCardModel(backgroundColor = Color.parseColor("#5d4037")),
            CreditCardModel(backgroundColor = Color.parseColor("#616161")),
            CreditCardModel(backgroundColor = Color.parseColor("#455a64")),
            CreditCardModel(backgroundColor = Color.parseColor("#263238"))
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
        stream.value = CreditCardsHorizontalModel(
                cardOne = cardOneLeft,
                cardTwo = cardTwoLeft,
                cardThree = cardThreeLeft,
                cardFour = cardFourLeft,
                cardFive = cardFive)
    }
}