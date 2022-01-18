package com.weronika.coffeehouse.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weronika.coffeehouse.model.User

class LoginViewModel : ViewModel() {

    private val user = MutableLiveData(User("", ""))

    fun userEmail(): String = user.value?.name ?: ""
    fun userPassword(): String = user.value?.password ?: ""
    fun setUserEmail(userName: String) { user.value?.name = userName }
    fun setPassword(userPassword: String) { user.value?.password = userPassword }
}