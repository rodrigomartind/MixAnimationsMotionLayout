package com.rodrigodominguez.mixanimationsmotionlayout.storiesinstagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigodominguez.mixanimationsmotionlayout.R
import kotlinx.android.synthetic.main.activity_instagram_story_home.*

class InstagramStoryHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instagram_story_home)

        demoInstagram.setOnClickListener {
            startActivity(
                Intent(this, InstagramStoryDemoActivity::class.java)
            )
        }
    }
}