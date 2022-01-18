package com.weronika.coffeehouse.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weronika.coffeehouse.model.Order

class OrderViewModel : ViewModel() {

    private val _order = MutableLiveData(Order)
    private val order: LiveData<Order> = _order

    fun get() = order.value?.get()
    fun delete(index: Int) = order.value?.deleteItem(index)
    fun deleteOrder() = order.value?.delete()
}