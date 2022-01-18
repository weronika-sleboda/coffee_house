package com.weronika.coffeehouse.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.weronika.coffeehouse.R
import com.weronika.coffeehouse.model.MenuItem

class OrderRecyclerAdapter(listener: OrderListener, order: List<MenuItem>) :
    RecyclerView.Adapter<OrderRecyclerAdapter.ViewHolder>() {

    private val orderListener = listener
    private val orderList = order

    interface OrderListener {
        fun onClickOrder(position: Int)
    }

    inner class ViewHolder(listener: OrderListener, view: View) : RecyclerView.ViewHolder(view) {

        private val orderListener = listener
        val orderName: TextView = view.findViewById(R.id.order_item_name)
        val orderPrice: TextView = view.findViewById(R.id.order_item_price)
        private val trashButton: ImageView = view.findViewById(R.id.trash_button)

        init {
            trashButton.setOnClickListener {
                orderListener.onClickOrder(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.order_layout, parent, false
        )
        return ViewHolder(orderListener, view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.orderName.text = orderList[position].name
        
        val text =  orderList[position].price.toString() + "kr"
        viewHolder.orderPrice.text = text
    }

    override fun getItemCount(): Int {
        return orderList.size
    }
}