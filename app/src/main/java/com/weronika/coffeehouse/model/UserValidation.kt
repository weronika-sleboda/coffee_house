package com.weronika.coffeehouse.model

import android.content.Context
import com.weronika.coffeehouse.model.database.AccountDatabase
import kotlinx.coroutines.coroutineScope
import java.lang.Exception

class UserValidation(context: Context) {

    private val database by lazy {

        AccountDatabase.getDatabase(context)
    }

    suspend fun userIsValid(email: String, password: String): Boolean {

        var userEmail: Boolean
        var userPassword: Boolean

        try {
            coroutineScope {
                val response = database.accountDao().findEmail(email)
                userEmail = response == email
            }
        }
        catch (exception: Exception) { userEmail = false }

        try {
            coroutineScope {
                val response = database.accountDao().findPassword(email)
                userPassword = response == password
            }
        }
        catch (exception: Exception) { userPassword = false }

        return userEmail && userPassword
    }

}