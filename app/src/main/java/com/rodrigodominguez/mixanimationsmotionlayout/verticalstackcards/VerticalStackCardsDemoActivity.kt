package com.rodrigodominguez.mixanimationsmotionlayout.verticalstackcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rodrigodominguez.mixanimationsmotionlayout.R
import kotlinx.android.synthetic.main.activity_vertical_stack_cards_demo.*

class VerticalStackCardsDemoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_stack_cards_demo)

        val viewModel = ViewModelProviders
            .of(this)
            .get(VerticalStackCardViewModel::class.java)

        viewModel
            .modelStream
            .observe(this, Observer {
                bindCard(it)
            })

        verticalMotionLayout.setTransitionListener(object : TransitionAdapter() {
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                motionLayout?.post {
                    when (currentId) {
                        R.id.end -> {
                            verticalMotionLayout.progress = 0f
                            verticalMotionLayout.progress = 0f
                            viewModel.swipe()
                        }
                    }
                }
            }
        })
    }

    private fun bindCard(it: VerticalCardModel) {
        cardDetail.setCardBackgroundColor(it.detailCard.backgroundColor)
        cardTop.setCardBackgroundColor(it.cardTop.backgroundColor)
        cardMiddle.setCardBackgroundColor(it.cardMiddle.backgroundColor)
        cardBottom.setCardBackgroundColor(it.cardBottom.backgroundColor)
        cardEnd.setCardBackgroundColor(it.cardEnd.backgroundColor)
        cardTransparent.setCardBackgroundColor(it.cardTransparent.backgroundColor)
    }
}