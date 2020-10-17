package com.rodrigodominguez.mixanimationsmotionlayout.storiesinstagram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rodrigodominguez.mixanimationsmotionlayout.R
import kotlinx.android.synthetic.main.activity_instagram_story_demo.*
import kotlinx.android.synthetic.main.layout_story.*
import kotlinx.android.synthetic.main.layout_story_two.*

class InstagramStoryDemoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instagram_story_demo)

        val viewModel = ViewModelProviders
            .of(this)
            .get(StoriesViewModel::class.java)

        viewModel
            .modelStream
            .observe(this, Observer {
                bindCard(it)
            })

        storyMotionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                storyMotionDetail.progress = p3
                storyMotionDetailTwo.progress = 1 - p3
            }

            override fun onTransitionCompleted(p0: MotionLayout?, currentId: Int) {
                p0?.post {
                    when (currentId) {
                        R.id.end -> {
                            storyMotionDetail.progress = 0f
                            storyMotionLayout.progress = 0f
                            viewModel.swipe()
                        }
                    }
                }
            }

        })

    }

    private fun bindCard(it: StoryModel) {
        storyOne.setCardBackgroundColor(it.cardTop.backgroundColor)
        storyTwo.setCardBackgroundColor(it.cardBottom.backgroundColor)
    }
}