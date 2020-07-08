package com.rodrigodominguez.mixanimationsmotionlayout.carousel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rodrigodominguez.mixanimationsmotionlayout.R
import kotlinx.android.synthetic.main.activity_carousel_test.*

class CarouselTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousel_test)

        val viewModel = ViewModelProviders
            .of(this)
            .get(CarouselStepViewModel::class.java)

        viewModel
            .modelStream
            .observe(this, Observer {
                bindCard(it)
            })

        carouselMotionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
            }

            override fun onTransitionCompleted(p0: MotionLayout?, currentId: Int) {
                when (currentId) {
                    R.id.centerTwo -> {
                        if (viewModel.isAnteUltimo()){
                            carouselMotionLayout.setTransition(R.id.centerTwo, R.id.end)
                            carouselMotionLayout.progress = 0f
                            //viewModel.swipeRight()
                        } else {
                            carouselMotionLayout.progress = 0f
                            carouselMotionLayout.setTransition(R.id.center, R.id.centerTwo)
                            viewModel.swipeRight()
                        }
                    }

                }
            }

        })
    }


    private fun bindCard(stepModel: StepModel?) {
        stepModel?.let {
            cardOne.setCardBackgroundColor(it.cardOne.backgroundColor)
            cardTwo.setCardBackgroundColor(it.cardTwo.backgroundColor)
            cardThree.setCardBackgroundColor(it.cardThree.backgroundColor)
            cardFour.setCardBackgroundColor(it.cardFour.backgroundColor)
        }
    }
}