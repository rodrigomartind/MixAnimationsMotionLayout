package com.rodrigodominguez.mixanimationsmotionlayout.starbucks

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rodrigodominguez.mixanimationsmotionlayout.R
import com.rodrigodominguez.mixanimationsmotionlayout.starbucks.data.Product
import kotlinx.android.synthetic.main.activity_starbucks_detail.*
import kotlinx.android.synthetic.main.detail_container_starbucks.*
import kotlinx.android.synthetic.main.list_products_motion_layout.*


class StarbucksDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_starbucks_detail)

        sizeS.setOnClickListener {
            updateImageSize(it,
                    R.dimen.paddingS
            )
            ammount.text = "$3,95"
        }
        sizeM.setOnClickListener {
            updateImageSize(it,
                    R.dimen.paddingM
            )
            ammount.text = "$4,45"
        }
        sizeL.setOnClickListener {
            updateImageSize(it,
                    R.dimen.paddingL
            )
            ammount.text = "$4,95"
        }


        starbucksMotion.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {
            }

            override fun onTransitionChange(p0: MotionLayout?, start: Int, end: Int, p3: Float) {
                if (end == R.id.end) {
                    motionProducts.setTransition(R.id.start, R.id.intermediate)
                    motionProducts.transitionToState(R.id.intermediate)
                }
            }

            override fun onTransitionCompleted(p0: MotionLayout?, currentId: Int) {
            }
        })

        listItems.layoutManager = LinearLayoutManager(this)
        listItems.adapter = ItemsStarbucksAdapter(getItems())
    }

    private fun getItems(): List<Product> {
        return listOf(
                Product("Cool Lime Starbucks Refreshers™", "Size L", R.drawable.green_starbucks, 3.25f, 1),
                Product("Mocha Frappuccino®", "Size M", R.drawable.mocha, 3.75f, 1))
    }

    private fun updateImageSize(view: View, padding: Int) {
        view.background = resources.getDrawable(R.drawable.shape_size_cup_selected, null)
        setPadding(view, padding)
        when (view.id) {
            R.id.sizeL -> {
                sizeM.background = resources.getDrawable(R.drawable.shape_size_cup, null)
                setPadding(sizeM,
                        R.dimen.paddingM
                )
                sizeS.background = resources.getDrawable(R.drawable.shape_size_cup, null)
                setPadding(sizeS,
                        R.dimen.paddingS
                )
            }
            R.id.sizeM -> {
                sizeL.background = resources.getDrawable(R.drawable.shape_size_cup, null)
                setPadding(sizeL,
                        R.dimen.paddingL
                )
                sizeS.background = resources.getDrawable(R.drawable.shape_size_cup, null)
                setPadding(sizeS,
                        R.dimen.paddingS
                )
            }
            R.id.sizeS -> {
                sizeM.background = resources.getDrawable(R.drawable.shape_size_cup, null)
                setPadding(sizeM,
                        R.dimen.paddingM
                )
                sizeL.background = resources.getDrawable(R.drawable.shape_size_cup, null)
                setPadding(sizeL,
                        R.dimen.paddingL
                )
            }
        }
    }

    private fun setPadding(view: View, padding: Int) {
        val valueInPixels = resources.getDimension(padding).toInt()
        view.setPadding(valueInPixels, valueInPixels, valueInPixels, valueInPixels)
    }
}