package com.rodrigodominguez.mixanimationsmotionlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigodominguez.mixanimationsmotionlayout.circularcards.CircularCardsHomeActivity
import com.rodrigodominguez.mixanimationsmotionlayout.rotationcard.RotationCardActivity
import com.rodrigodominguez.mixanimationsmotionlayout.storiesinstagram.InstagramStoryDemoActivity
import com.rodrigodominguez.mixanimationsmotionlayout.storiesinstagram.InstagramStoryHomeActivity
import com.rodrigodominguez.mixanimationsmotionlayout.verticalstackcards.VerticalStackCardsHomeActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storiesHome.setOnClickListener {
            startActivity(
                Intent(this, InstagramStoryHomeActivity::class.java)
            )
        }
        circularCards.setOnClickListener {
            startActivity(
                Intent(this, CircularCardsHomeActivity::class.java)
            )
        }
        rotationCardScenes.setOnClickListener {
            startActivity(
                Intent(this, RotationCardActivity::class.java)
            )
        }

        verticalCards.setOnClickListener {
            startActivity(
                Intent(this, VerticalStackCardsHomeActivity::class.java)
            )
        }
    }
}
