package com.rodrigodominguez.mixanimationsmotionlayout.menuselection

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.helper.widget.Carousel
import com.google.android.material.card.MaterialCardView
import com.rodrigodominguez.mixanimationsmotionlayout.R
import kotlinx.android.synthetic.main.activity_menu_selection_carousel.*

class MenuSelectionCarouselActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_selection_carousel)
        setupCarousel()
    }

    private fun setupCarousel() {
        val carousel = findViewById<Carousel>(R.id.carouselMenu) ?: return
        val numImages = items.size

        carousel.setAdapter(object : Carousel.Adapter {
            override fun count(): Int {
                return numImages
            }

            override fun populate(view: View, index: Int) {
                val item = items[index]
                if (view is MaterialCardView) {
                    view.setCardBackgroundColor(item.color)
                }
                ("$" + item.price.toString()).also { priceMenu.text = it }
                titleMenu.text = item.title
                (ingredient_1 as MaterialCardView).setBackgroundColor(item.ingredients[0])
                (ingredient_2 as MaterialCardView).setBackgroundColor(item.ingredients[1])
                (ingredient_3 as MaterialCardView).setBackgroundColor(item.ingredients[2])
                (ingredient_4 as MaterialCardView).setBackgroundColor(item.ingredients[3])
            }

            override fun onNewItem(index: Int) {
            }
        })
    }

    var items = arrayOf(
        MenuItem(color = Color.parseColor("#1b5e20"), "Pizza 1", 10.5F,
            arrayOf(
                Color.parseColor("#b9f6ca"),
                Color.parseColor("#69f0ae"),
                Color.parseColor("#00e676"),
                Color.parseColor("#00e676")
            )),
        MenuItem(color = Color.parseColor("#33691e"), "Pizza 2", 13.35F,
            arrayOf(
                Color.parseColor("#ccff90"),
                Color.parseColor("#b2ff59"),
                Color.parseColor("#76ff03"),
                Color.parseColor("#64dd17")
            )),
        MenuItem(color = Color.parseColor("#827717"), "Pizza 3", 23.11F,
            arrayOf(
                Color.parseColor("#f4ff81"),
                Color.parseColor("#f4ff81"),
                Color.parseColor("#c6ff00"),
                Color.parseColor("#aeea00")
            )),
        MenuItem(color = Color.parseColor("#f57f17"), "Pizza 4", 14.22F,
            arrayOf(
                Color.parseColor("#ffff8d"),
                Color.parseColor("#ffff00"),
                Color.parseColor("#ffea00"),
                Color.parseColor("#ffd600")
            )),
        MenuItem(color = Color.parseColor("#ff6f00"), "Pizza 5", 9.32F,
            arrayOf(
                Color.parseColor("#ffe57f"),
                Color.parseColor("#ffd740"),
                Color.parseColor("#ffc400"),
                Color.parseColor("#ffab00")
            )),
        MenuItem(color = Color.parseColor("#e65100"), "Pizza 6", 33.4F,
            arrayOf(
                Color.parseColor("#ffd180"),
                Color.parseColor("#ffab40"),
                Color.parseColor("#ff9100"),
                Color.parseColor("#ff6d00")
            )),
    )
}

data class MenuItem(val color: Int, val title: String, val price: Float, val ingredients: Array<Int>)