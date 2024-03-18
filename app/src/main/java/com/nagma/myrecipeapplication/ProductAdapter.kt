package com.nagma.myrecipeapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nagma.myrecipeapplication.data.Product
import com.nagma.myrecipeapplication.databinding.ItemBinding
import java.text.NumberFormat

class ProductAdapter(private val items:List<Product>)
    : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = items[position]

        with(holder.binding){
            productNameText.text = product.name
            sizeText.text = sizeText.context.resources.getString(
                R.string.product_size_label, product.size
            )
            priceText.text = NumberFormat.getCurrencyInstance().format(product.price)
        }

    }


}