package com.rodrigodominguez.mixanimationsmotionlayout.rotationcard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigodominguez.mixanimationsmotionlayout.R
import com.rodrigodominguez.mixanimationsmotionlayout.rotationcard.scenes.RotationCardScene1Activity
import com.rodrigodominguez.mixanimationsmotionlayout.rotationcard.scenes.RotationCardScene2Activity
import kotlinx.android.synthetic.main.activity_rotation_card_home.*

class RotationCardHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rotation_card_home)
        demoRotationCard.setOnClickListener {
            startActivity(
                Intent(this, RotationCardDemoActivity::class.java)
            )
        }
        rotationCardScene1.setOnClickListener {
            startActivity(
                Intent(this, RotationCardScene1Activity::class.java)
            )
        }
        rotationCardScene2.setOnClickListener {
            startActivity(
                Intent(this, RotationCardScene2Activity::class.java)
            )
        }
    }
}