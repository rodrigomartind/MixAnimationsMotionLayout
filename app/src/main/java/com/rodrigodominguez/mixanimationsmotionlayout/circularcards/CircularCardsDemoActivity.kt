package com.rodrigodominguez.mixanimationsmotionlayout.circularcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rodrigodominguez.mixanimationsmotionlayout.R
import kotlinx.android.synthetic.main.activity_circular_cards_demo.*

class CircularCardsDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_cards_demo)
        val viewModel = ViewModelProviders
            .of(this)
            .get(CreditCardsViewModel::class.java)

        viewModel
            .modelStream
            .observe(this, Observer {
                bindCard(it)
            })

        motionLayout.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                motionLayout.post {
                    when (currentId) {
                        R.id.secondCard -> {
                            motionLayout.progress = 0f
                            viewModel.swipeRight()
                        }
                        R.id.firstCard -> {
                            motionLayout.progress = 0f
                            viewModel.swipeLeft()
                        }
                    }
                }
            }
        })
    }

    private fun bindCard(it: CreditCardsModel) {
        cardLeft1.setCardBackgroundColor(it.cardFourLeft.backgroundColor)
        cardLeft2.setCardBackgroundColor(it.cardThreeLeft.backgroundColor)
        cardLeft3.setCardBackgroundColor(it.cardTwoLeft.backgroundColor)
        cardLeft4.setCardBackgroundColor(it.cardOneLeft.backgroundColor)
        cardCenter.setCardBackgroundColor(it.cardCenter.backgroundColor)
        cardRight1.setCardBackgroundColor(it.cardOneRight.backgroundColor)
        cardRight2.setCardBackgroundColor(it.cardTwoRight.backgroundColor)
        cardRight3.setCardBackgroundColor(it.cardThreeRight.backgroundColor)
        cardRight4.setCardBackgroundColor(it.cardFourRight.backgroundColor)
    }
}