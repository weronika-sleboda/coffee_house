package com.weronika.coffeehouse.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.weronika.coffeehouse.R
import com.weronika.coffeehouse.databinding.OrderActivityBinding
import com.weronika.coffeehouse.viewmodel.OrderViewModel

class OrderActivity : AppCompatActivity() {

    private lateinit var binding : OrderActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = OrderActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<OrderFragment>(R.id.order_fragment_container)
        }
    }
}