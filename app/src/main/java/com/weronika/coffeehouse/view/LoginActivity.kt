package com.weronika.coffeehouse.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.weronika.coffeehouse.databinding.LoginActivityBinding
import com.weronika.coffeehouse.model.UserValidation
import com.weronika.coffeehouse.model.ValidEmail
import com.weronika.coffeehouse.model.database.AccountDatabase
import com.weronika.coffeehouse.viewmodel.AccountViewModel
import com.weronika.coffeehouse.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding : LoginActivityBinding
    private val viewModel = LoginViewModel()
    private lateinit var database: AccountDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //*** Data and view binding
        binding = LoginActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //*** Data binding
        binding.user = viewModel

        setupLoginButton()
        setupCreateAccountButton()
        setupDatabase()
    }

    private fun setupDatabase() {
        database = AccountDatabase.getDatabase(applicationContext)
    }

    private fun refreshEditTextFields() {

        //*** View binding
        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()

        viewModel.setUserEmail(email)
        viewModel.setPassword(password)
    }

    private fun setupLoginButton() {

        binding.logInButton.setOnClickListener {

            refreshEditTextFields()

            val givenEmail = viewModel.userEmail()
            val givenPassword = viewModel.userPassword()

            val userValidation = UserValidation(this)
            lifecycleScope.launch {

                val userIsValid = userValidation.userIsValid(
                    givenEmail, givenPassword)

                if(userIsValid) {

                    ValidEmail.email = givenEmail
                    val intent = Intent(baseContext, HomeActivity::class.java)
                    startActivity(intent)
                }

                else {
                    Toast.makeText(baseContext, "Your email or password are incorrect",
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    
    private fun setupCreateAccountButton() {

        binding.createAccountButton.setOnClickListener {

            val intent = Intent(this,
                CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }
}