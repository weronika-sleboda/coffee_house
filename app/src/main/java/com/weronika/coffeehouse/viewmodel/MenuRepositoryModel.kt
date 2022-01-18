package com.weronika.coffeehouse.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weronika.coffeehouse.model.Menu
import com.weronika.coffeehouse.model.MenuItem

class MenuRepositoryModel : ViewModel() {

    private val _menu = MutableLiveData<List<MenuItem>>(Menu.repository)
    private val menu: LiveData<List<MenuItem>> = _menu

    fun menuItems() = menu
}