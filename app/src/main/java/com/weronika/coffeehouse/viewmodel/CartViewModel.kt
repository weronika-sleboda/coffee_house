package com.weronika.coffeehouse.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weronika.coffeehouse.model.Cart
import com.weronika.coffeehouse.model.MenuItem
import com.weronika.coffeehouse.model.Order

class CartViewModel : ViewModel() {

    private val cart = MutableLiveData(Cart(0))

    fun empty() {

        cart.value?.amount = 0
        Order.delete()
    }

    fun amount(): Int = cart.value?.amount ?: 0

    fun amountToString(): String {
        return "Cart: " + cart.value?.amount
    }

    fun update() {
        cart.value?.amount = Order.numberOfOrders()
    }
    fun addItemToCart(menuItem: MenuItem) {

        val amount = 1 + cart.value?.amount!!
        cart.value?.amount = amount

        if(cart.value?.amount!! > 99) {
            cart.value?.amount = 99
        }

        Order.create(menuItem)
    }
}