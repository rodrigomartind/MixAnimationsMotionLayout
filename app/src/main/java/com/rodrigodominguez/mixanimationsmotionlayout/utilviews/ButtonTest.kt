package com.rodrigodominguez.mixanimationsmotionlayout.utilviews

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.Animatable
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.rodrigodominguez.mixanimationsmotionlayout.R

class ButtonTest @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr), Animatable {
    init {
        inflate(context, R.layout.test_custom_view, this)
    }

    override fun setProgress(p0: Float) {
        this.progress = p0
    }

    override fun getProgress(): Float {
        return progress
    }

}