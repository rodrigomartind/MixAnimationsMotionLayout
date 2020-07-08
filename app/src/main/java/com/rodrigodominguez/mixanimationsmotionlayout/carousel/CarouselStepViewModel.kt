package com.rodrigodominguez.mixanimationsmotionlayout.carousel

import android.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class CarouselStepViewModel : ViewModel() {

    private val stream = MutableLiveData<StepModel>()

    val modelStream: LiveData<StepModel>
        get() = stream

    private val data = listOf(
        Step(
            backgroundColor = Color.parseColor("#4b636e")
        ),
        Step(
            backgroundColor = Color.parseColor("#c56200")
        ),
        Step(
            backgroundColor = Color.parseColor("#c79400")
        ),
        Step(
            backgroundColor = Color.parseColor("#c7b800")
        ),
        Step(
            backgroundColor = Color.parseColor("#90cc00")
        ),
        Step(
            backgroundColor = Color.parseColor("#eeea00")
        ),
        Step(
            backgroundColor = Color.parseColor("#90c333")
        )
    )
    var currentIndex = 0

    private val cardOne
        get() = data[currentIndex % data.size]
    private val cardTwo
        get() = data[(currentIndex + 1) % data.size]
    private val cardThree
        get() = data[(currentIndex + 2) % data.size]
    private val cardFour
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

    fun isAnteUltimo(): Boolean {
        return currentIndex == data.size - 4
    }

    fun isTwerty(): Boolean {
        return currentIndex == 3
    }

    private fun updateCards() {
        stream.value = StepModel(
            cardOne = cardOne,
            cardTwo = cardTwo,
            cardThree = cardThree,
            cardFour = cardFour
        )
    }

}