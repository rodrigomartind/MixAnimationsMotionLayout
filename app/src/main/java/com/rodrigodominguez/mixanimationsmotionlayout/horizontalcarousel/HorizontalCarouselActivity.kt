package com.rodrigodominguez.mixanimationsmotionlayout.horizontalcarousel

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.helper.widget.Carousel
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.google.android.material.card.MaterialCardView
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
    var colors = intArrayOf(
        Color.parseColor("#81d4fa"),
        Color.parseColor("#4fc3f7"),
        Color.parseColor("#29b6f6"),
        Color.parseColor("#03a9f4"),
        Color.parseColor("#039be5"),
        Color.parseColor("#0288d1"),
        Color.parseColor("#0277bd"),
        Color.parseColor("#01579b")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horizontal_carousel)
        setupCarousel()
    }

    private fun setupCarousel() {
        val carousel = findViewById<Carousel>(R.id.carouselSnake) ?: return
        val numImages = colors.size

        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return numImages
            }

            override fun populate(view: View, index: Int) {
                if (view is MaterialCardView) {
                    view.setBackgroundColor(colors[index])
                }
            }

            override fun onNewItem(index: Int) {
            }
        })
    }
}