package com.weronika.coffeehouse.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.weronika.coffeehouse.databinding.OrderRecyclerFragmentBinding
import com.weronika.coffeehouse.view.OrderDialogFragment.Companion.DIALOG_TAG
import com.weronika.coffeehouse.viewmodel.OrderViewModel

class OrderFragment : Fragment(), OrderRecyclerAdapter.OrderListener {

    private lateinit var binding: OrderRecyclerFragmentBinding
    private val layoutManager = LinearLayoutManager(context)
    private lateinit var adapter: OrderRecyclerAdapter
    private val orderViewModel = OrderViewModel()
    private val orderDialogFragment = OrderDialogFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = OrderRecyclerFragmentBinding.inflate(inflater,
            container, false)

        binding.orderRecycler.layoutManager = layoutManager
        adapter = orderViewModel.get()?.let { OrderRecyclerAdapter(this, it) }!!
        binding.orderRecycler.adapter = adapter
        setupPlaceOrderFab()
        setupHomeButton()
        return binding.root
    }

    override fun onClickOrder(position: Int) {
        orderViewModel.delete(position)
        adapter = orderViewModel.get()?.let { OrderRecyclerAdapter(this, it) }!!
        binding.orderRecycler.adapter = adapter
    }

    private fun setupPlaceOrderFab() {
        binding.placeOrderFab.setOnClickListener {
            orderViewModel.deleteOrder()
            orderDialogFragment.show(childFragmentManager, DIALOG_TAG)
            orderDialogFragment.isCancelable = false
        }
    }

    private fun setupHomeButton() {
        binding.homeButton.setOnClickListener {
            val intent = Intent(context, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}