package com.rodrigodominguez.mixanimationsmotionlayout.horizontalcarousel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.rodrigodominguez.mixanimationsmotionlayout.R
import com.rodrigodominguez.mixanimationsmotionlayout.circularcards.CreditCardsViewModel
import kotlinx.android.synthetic.main.activity_circular_cards_demo.*
import kotlinx.android.synthetic.main.activity_horizontal_carousel.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import kotlin.concurrent.schedule

class HorizontalCarouselActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_carousel)
        val viewModel = ViewModelProviders
            .of(this)
            .get(CreditCardsHorizontalViewModel::class.java)

        viewModel
            .modelStream
            .observe(this, Observer {
                bindCard(it)
            })

//        motionHorizontalParent.setTransitionListener(object : TransitionAdapter() {
//            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
//                when (currentId) {
//                    R.id.end -> {
//                        motionLayout.progress = 0f
//                        motionLayout.setTransition(R.id.start, R.id.end)
//                        viewModel.swipeRight()
//                    }
////                    R.id.firstCard -> {
////                        motionLayout.progress = 0f
////                        motionLayout.setTransition(R.id.start, R.id.secondCard)
////                        viewModel.swipeLeft()
////                    }
//                }
//            }
//        })

        motionHorizontalParent.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, p1: Int) {
                p0?.post {
                    when (p1) {
                        R.id.end -> {
                            p0.progress = 0f
                            viewModel.swipeRight()
                        }
                    }
                }

            }

        })
    }

    private fun bindCard(cards: CreditCardsHorizontalModel?) {
        cards?.let {
            itemOne.setBackgroundColor(it.cardOne.backgroundColor)
            itemTwo.setBackgroundColor(it.cardTwo.backgroundColor)
            itemThree.setBackgroundColor(it.cardThree.backgroundColor)
            itemFour.setBackgroundColor(it.cardFour.backgroundColor)
            itemFive.setBackgroundColor(it.cardFive.backgroundColor)
        }
    }
}