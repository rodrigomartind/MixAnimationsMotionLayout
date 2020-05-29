package com.rodrigodominguez.mixanimationsmotionlayout.examplekeyposition

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigodominguez.mixanimationsmotionlayout.R
import kotlinx.android.synthetic.main.activity_position_key_example.*

class PositionKeyExampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_position_key_example)

        keyPositionDelta.setOnClickListener {
            startActivity(
                Intent(this, KeyPositionDeltaActivity::class.java)
            )
        }

        keyPositionParent.setOnClickListener {
            startActivity(
                Intent(this, KeyPositionParentActivity::class.java)
            )
        }

        keyPositionPath.setOnClickListener {
            startActivity(
                Intent(this, KeyPositionPathActivity::class.java)
            )
        }
    }
}