package com.weronika.coffeehouse.model

class AccountValidation {

    fun firstNameIsValid(firstName: String): Boolean {
        if(firstName.isEmpty()) {return false}
        return true
    }

    fun lastNameIsValid(lastName: String): Boolean {
        if(lastName.isEmpty()) {return false}
        return true
    }

    fun emailIsValid(email: String): Boolean {

        var isValid = false
        for(symbol in email) {
            if(symbol == '@') {
                isValid = true
            }
        }

        if(email.length < 6) {return false}

        return isValid
    }

    fun passwordIsValid(password: String): Boolean {
        if(password.length < 6) {return false}
        return true
    }
}