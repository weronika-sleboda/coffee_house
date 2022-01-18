package com.weronika.coffeehouse.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.weronika.coffeehouse.model.Account
import com.weronika.coffeehouse.model.ValidEmail
import com.weronika.coffeehouse.model.database.AccountDatabase
import java.lang.Exception

class AccountViewModel(context: Context) : ViewModel() {

    private val account = MutableLiveData(Account("","","",""))
    private val database by lazy { AccountDatabase.getDatabase(context) }

    suspend fun updateProfile() {

        try {
            account.value?.firstName = database.accountDao()
                .findFirstName(ValidEmail.email)
            account.value?.lastName = database.accountDao()
                .findLastName(ValidEmail.email)
            account.value?.email = database.accountDao()
                .findEmail(ValidEmail.email)
            account.value?.password = database.accountDao()
                .findPassword(ValidEmail.email)
        }
        catch (exception: Exception) {}
    }

    fun firstName(): String {

        return "First Name: " + account.value?.firstName!!
    }

    fun lastName(): String {

        return "Last Name: " + account.value?.lastName!!
    }

    fun email(): String {

        return "Email" + account.value?.email!!
    }

    fun password(): String {

        return "Password: " + account.value?.password!!
    }
}