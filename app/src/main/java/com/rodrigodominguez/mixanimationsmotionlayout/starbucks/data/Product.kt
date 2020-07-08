package com.rodrigodominguez.mixanimationsmotionlayout.starbucks.data

import androidx.annotation.DrawableRes

data class Product(
    val title: String,
    val description: String,
    @DrawableRes
    val resource: Int,
    val price: Float,
    val count: Int
)