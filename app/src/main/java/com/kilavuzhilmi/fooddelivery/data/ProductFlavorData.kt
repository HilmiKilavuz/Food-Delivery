package com.kilavuzhilmi.fooddelivery.data

import androidx.annotation.DrawableRes
import com.kilavuzhilmi.fooddelivery.R

data class ProductFlavorState(
    val name: String,
    val price: String,
    @DrawableRes val image: Int
)

val ProductFlavorsData = listOf(
    ProductFlavorState(
        "Chedder", "$0.79", R.drawable.img_cheese
    ),
    ProductFlavorState(
        "Bacon",
        "$0.52",
        R.drawable.img_bacon
    ),
    ProductFlavorState(
        "Onion",
        "$0.28",
        R.drawable.img_onion
    )
)