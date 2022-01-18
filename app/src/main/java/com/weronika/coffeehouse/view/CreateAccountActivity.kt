package com.weronika.coffeehouse.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.weronika.coffeehouse.databinding.CreateAccountActivityBinding
import com.weronika.coffeehouse.model.AccountValidation
import com.weronika.coffeehouse.model.ValidEmail
import com.weronika.coffeehouse.model.database.AccountDatabase
import com.weronika.coffeehouse.model.database.AccountTable
import kotlinx.coroutines.launch

class CreateAccountActivity : AppCompatActivity() {

    private lateinit var binding: CreateAccountActivityBinding
    private lateinit var database: AccountDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = CreateAccountActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupCreateButton()
        setupDatabase()
        setupGoToLogInButton()
    }
    
    private fun setupDatabase() {
        database = AccountDatabase.getDatabase(applicationContext)
    }

    private fun setupCreateButton() {

        binding.createButton.setOnClickListener {

            val firstName = binding.firstNameEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            val email = binding.userEmailEditText.text.toString()
            val password = binding.userPasswordEditText.text.toString()

            val validation = AccountValidation()

            if(!validation.firstNameIsValid(email)) {
                Toast.makeText(baseContext, "First name is too short",
                    Toast.LENGTH_SHORT).show()
            }
            else if(!validation.lastNameIsValid(email)) {
                Toast.makeText(baseContext, "Last name is too short",
                    Toast.LENGTH_SHORT).show()
            }
            else if(!validation.emailIsValid(email)) {
                Toast.makeText(baseContext, "Email is too short or it's incorrect",
                    Toast.LENGTH_SHORT).show()
            }
            else if(!validation.passwordIsValid(email)) {
                Toast.makeText(baseContext, "Password is too short",
                    Toast.LENGTH_SHORT).show()
            }
            else {
                lifecycleScope.launch {

                    database.accountDao().insert(
                        AccountTable(
                            email,
                            firstName,
                            lastName,
                            email,
                            password
                        )
                    )

                    ValidEmail.email = email
                }

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setupGoToLogInButton() {

        binding.goToLogInButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}