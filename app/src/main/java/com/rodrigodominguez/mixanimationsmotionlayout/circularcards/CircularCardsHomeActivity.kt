package com.rodrigodominguez.mixanimationsmotionlayout.circularcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigodominguez.mixanimationsmotionlayout.R
import kotlinx.android.synthetic.main.activity_circular_cards_home.*

class CircularCardsHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circular_cards_home)
        circularCardsScene1.setOnClickListener {
            startActivity(
                Intent(this, CircularCardsScene1Activity::class.java)
            )
        }
    }
}