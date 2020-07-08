package com.rodrigodominguez.mixanimationsmotionlayout.starbucks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rodrigodominguez.mixanimationsmotionlayout.R
import com.rodrigodominguez.mixanimationsmotionlayout.starbucks.data.Product
import kotlinx.android.synthetic.main.item_product_starbucks.view.*

class ItemsStarbucksAdapter(private val list: List<Product>) : RecyclerView.Adapter<ItemsStarbucksAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_product_starbucks, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemsStarbucksAdapter.ViewHolder, position: Int) = holder.bind(list[position])


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Product) = with(itemView) {
            image.setImageDrawable(context.getDrawable(item.resource))
            titleProduct.text = item.title
            priceProduct.text = """${"$ "}${item.price}"""
            descriptionProduct.text = item.description
            count.text = """x ${item.count}"""
        }
    }

}