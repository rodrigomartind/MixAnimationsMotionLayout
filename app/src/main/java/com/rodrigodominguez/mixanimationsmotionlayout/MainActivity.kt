package com.rodrigodominguez.mixanimationsmotionlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rodrigodominguez.mixanimationsmotionlayout.carouselhelper.CarouselHelperActivity
import com.rodrigodominguez.mixanimationsmotionlayout.circularcards.CircularCardsHomeActivity
import com.rodrigodominguez.mixanimationsmotionlayout.democonstraintset.DemoConstraintSetActivity
import com.rodrigodominguez.mixanimationsmotionlayout.examplekeyposition.PositionKeyExampleActivity
import com.rodrigodominguez.mixanimationsmotionlayout.flow.FlowDemoActivity
import com.rodrigodominguez.mixanimationsmotionlayout.horizontalcarousel.HorizontalCarouselActivity
import com.rodrigodominguez.mixanimationsmotionlayout.motionwithar.MotionAndAugmentedRealityActivity
import com.rodrigodominguez.mixanimationsmotionlayout.pillcards.PillCardsActivity
import com.rodrigodominguez.mixanimationsmotionlayout.pivotrotation.FoodCircleTabsActivity
import com.rodrigodominguez.mixanimationsmotionlayout.rotationcard.RotationCardHomeActivity
import com.rodrigodominguez.mixanimationsmotionlayout.sensor.CardSensorActivity
import com.rodrigodominguez.mixanimationsmotionlayout.starbucks.StarbucksDetailActivity
import com.rodrigodominguez.mixanimationsmotionlayout.storiesinstagram.InstagramStoryHomeActivity
import com.rodrigodominguez.mixanimationsmotionlayout.telegramheaderdemo.TelegramHeaderDemoActivity
import com.rodrigodominguez.mixanimationsmotionlayout.verticalsnake.VerticalSnakeActivity
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
                    Intent(this, RotationCardHomeActivity::class.java)
            )
        }

        verticalCards.setOnClickListener {
            startActivity(
                    Intent(this, VerticalStackCardsHomeActivity::class.java)
            )
        }
        positionKeyExamples.setOnClickListener {
            startActivity(
                    Intent(this, PositionKeyExampleActivity::class.java)
            )
        }

        starbucks.setOnClickListener {
            startActivity(
                    Intent(this, StarbucksDetailActivity::class.java)
            )
        }

        sensorButton.setOnClickListener {
            startActivity(
                    Intent(this, CardSensorActivity::class.java)
            )
        }

        snakeCarousel.setOnClickListener {
            startActivity(
                    Intent(this, HorizontalCarouselActivity::class.java)
            )
        }

        pillCardsButton.setOnClickListener {
            startActivity(
                    Intent(this, PillCardsActivity::class.java)
            )
        }

        demosConstraintSet.setOnClickListener {
            startActivity(
                    Intent(this, DemoConstraintSetActivity::class.java)
            )
        }

        flowDemo.setOnClickListener {
            startActivity(
                    Intent(this, FlowDemoActivity::class.java)
            )
        }

        telegramHeaderDemo.setOnClickListener {
            startActivity(
                    Intent(this, TelegramHeaderDemoActivity::class.java)
            )
        }

        ARExample.setOnClickListener {
            startActivity(
                Intent(this, MotionAndAugmentedRealityActivity::class.java)
            )
        }

        pivotDemo.setOnClickListener {
            startActivity(
                Intent(this, FoodCircleTabsActivity::class.java)
            )
        }

        carouselHelperActivity.setOnClickListener {
            startActivity(
                Intent(this, CarouselHelperActivity::class.java)
            )
        }

        snakeActivity.setOnClickListener {
            startActivity(
                Intent(this, VerticalSnakeActivity::class.java)
            )
        }
    }
}
