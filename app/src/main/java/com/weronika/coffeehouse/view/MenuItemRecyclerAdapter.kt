package com.weronika.coffeehouse.view

import android.view.LayoutInflater
import com.weronika.coffeehouse.model.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.weronika.coffeehouse.R

class MenuItemRecyclerAdapter(
    listener: MenuItemListener, menu: LiveData<List<MenuItem>>
) :
    RecyclerView.Adapter<MenuItemRecyclerAdapter.ViewHolder>() {

    private val menuItemListener = listener
    private val menuList = menu

    interface MenuItemListener {

        fun onClick(position: Int)
    }

    inner class ViewHolder(view: View, listener: MenuItemListener)
        : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val menuItemListener: MenuItemListener = listener
        val menuItemName: TextView = view.findViewById(R.id.menu_item_name)
        val menuItemPhoto: FrameLayout = view.findViewById(R.id.menu_item_photo)
        private val menuItemCartButton: ImageView = view.findViewById(R.id.cart_button)

        init {

            menuItemCartButton.setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            menuItemListener.onClick(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.menu_item_layout, parent, false)

        return ViewHolder(view, menuItemListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        viewHolder.menuItemName.text = menuList.value?.get(position)?.name
        menuList.value?.get(position)?.photo?.let {
            viewHolder.menuItemPhoto.setBackgroundResource(it)
        }
    }

    override fun getItemCount(): Int {
        return menuList.value?.size!!
    }
}