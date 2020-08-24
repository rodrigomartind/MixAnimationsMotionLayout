package com.rodrigodominguez.mixanimationsmotionlayout.sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rodrigodominguez.mixanimationsmotionlayout.R
import kotlinx.android.synthetic.main.activity_test_sensores_android.*
import kotlin.math.roundToInt


class CardSensorActivity : AppCompatActivity(), SensorEventListener {
    private var sensorManager: SensorManager? = null
    private var gravitySensor: Sensor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_sensores_android)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorManager?.let { sensorManager ->
            gravitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY)
        }
    }

    override fun onResume() {
        super.onResume()
        gravitySensor?.also { gravity ->
            sensorManager?.registerListener(this, gravity, SensorManager.SENSOR_DELAY_GAME)
        }
    }

    //unregister
    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let { sensorEvent ->
            val ejeZ = (sensorEvent.values[2] * 10) / 100
            if (ejeZ > 0 && ejeZ < 100) {
                if (ejeZ > rotationCardMotionLayout.progress + 0.04) {
                    rotationCardMotionLayout.progress = ejeZ
                }

                if (ejeZ < rotationCardMotionLayout.progress - 0.04) {
                    rotationCardMotionLayout.progress = ejeZ
                }
            }
        }
    }

}