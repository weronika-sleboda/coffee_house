package com.weronika.coffeehouse.model

object Order {

    private var newOrder = mutableListOf<MenuItem>()

    fun create(newItem: MenuItem) {

        newOrder.add(newItem)
    }

    fun get() = newOrder
    fun delete()  = newOrder.clear()

    fun deleteItem(index: Int) {
        newOrder.removeAt(index)
    }

    fun numberOfOrders(): Int = newOrder.size
}