package com.weronika.coffeehouse.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.weronika.coffeehouse.databinding.MenuListRecyclerFragmentBinding
import com.weronika.coffeehouse.viewmodel.CartViewModel
import com.weronika.coffeehouse.viewmodel.MenuRepositoryModel

class MenuFragment : Fragment(), MenuItemRecyclerAdapter.MenuItemListener {

    private var binding: MenuListRecyclerFragmentBinding? = null
    private val cartViewModel = CartViewModel()
    private val menuViewModel = MenuRepositoryModel()
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: MenuItemRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = MenuListRecyclerFragmentBinding.inflate(
            inflater, container, false)

        cartViewModel.update()
        binding?.cart = cartViewModel
        setupRecyclerView(context)
        setupFab()
        setupRemoveButton()

        return binding!!.root
    }
    
    private fun setupRecyclerView(context: Context?) {

        layoutManager = LinearLayoutManager(context)
        adapter = MenuItemRecyclerAdapter(
            this, menuViewModel.menuItems())

        //*** Data binding
        binding!!.menuListRecycler.layoutManager = layoutManager
        binding!!.menuListRecycler.adapter = adapter
    }

    private fun setupFab() {

        binding?.orderFab?.setOnClickListener {

            if(cartViewModel.amount() > 0) {

                val intent = Intent(activity?.baseContext, OrderActivity::class.java)
                startActivity(intent)
            }

            else {
                Toast.makeText(context,
                    "You don't have any items in the cart",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun setupRemoveButton() {

        binding?.removeButton?.setOnClickListener {
            cartViewModel.empty()
            binding?.cart = cartViewModel
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onClick(position: Int) {

        val menuItem = menuViewModel.menuItems().value?.get(position)
        if (menuItem != null) {
            cartViewModel.addItemToCart(menuItem)
        }

        binding?.cart = cartViewModel
    }
}