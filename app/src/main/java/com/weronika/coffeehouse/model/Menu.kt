package com.weronika.coffeehouse.model

import com.weronika.coffeehouse.R

object Menu {

    val repository = listOf<MenuItem>(

        MenuItem("Latte", R.drawable.latte, 45),
        MenuItem("Cappuccino", R.drawable.cappuccino, 40),
        MenuItem("Espresso", R.drawable.espresso, 32),
        MenuItem("Coffee", R.drawable.coffee, 28),
        MenuItem("Sandwich", R.drawable.sandwich, 65),
        MenuItem("Bagel", R.drawable.bagel, 70),
        MenuItem("Salad", R.drawable.sallad, 75),
        MenuItem("Juice", R.drawable.juice, 25),

    )
}