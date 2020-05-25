package com.rodrigodominguez.mixanimationsmotionlayout.verticalstackcards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigodominguez.mixanimationsmotionlayout.R
import com.rodrigodominguez.mixanimationsmotionlayout.verticalstackcards.scenes.VerticalStackCardsScene1Activity
import com.rodrigodominguez.mixanimationsmotionlayout.verticalstackcards.scenes.VerticalStackCardsScene2Activity
import com.rodrigodominguez.mixanimationsmotionlayout.verticalstackcards.scenes.VerticalStackCardsScene3Activity
import kotlinx.android.synthetic.main.activity_vertical_stack_cards_home.*

class VerticalStackCardsHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vertical_stack_cards_home)

        demo.setOnClickListener {
            startActivity(
                Intent(this, VerticalStackCardsDemoActivity::class.java)
            )
        }

        verticalStackScene1.setOnClickListener {
            startActivity(
                Intent(this, VerticalStackCardsScene1Activity::class.java)
            )
        }

        verticalStackScene2.setOnClickListener {
            startActivity(
                Intent(this, VerticalStackCardsScene2Activity::class.java)
            )
        }

        verticalStackScene3.setOnClickListener {
            startActivity(
                Intent(this, VerticalStackCardsScene3Activity::class.java)
            )
        }
    }
}