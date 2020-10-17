package com.rodrigodominguez.mixanimationsmotionlayout.democonstraintset

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigodominguez.mixanimationsmotionlayout.R
import kotlinx.android.synthetic.main.activity_demo_constraint_set.*

class DemoConstraintSetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo_constraint_set)

        btn_customAttribute.setOnClickListener {
            startActivity(Intent(this, CustomAttributeDemoActivity::class.java))
        }

        btn_layout.setOnClickListener {
            startActivity(Intent(this, LayoutDemoActivity::class.java))
        }

        btn_propertySet.setOnClickListener {
            startActivity(Intent(this, PropertySetDemoActivity::class.java))
        }

        btn_transform.setOnClickListener {
            startActivity(Intent(this, TransformDemoActivity::class.java))
        }

        btn_motion.setOnClickListener {
            startActivity(Intent(this, MotionDemoActivity::class.java))
        }
    }
}