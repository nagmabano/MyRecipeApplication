package com.nagma.myrecipeapplication

import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.nagma.myrecipeapplication.data.Product
import com.nagma.myrecipeapplication.data.ProductRepository
import com.nagma.myrecipeapplication.databinding.FragmentProductsBinding

class ProductsFragment : Fragment() {

    val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val product_list = view.findViewById<RecyclerView>(R.id.product_list)

        viewModel.products.observe(viewLifecycleOwner) { products ->
            product_list.adapter = object : GenericListAdapter<Product>(
                R.layout.item,
                bind = {item, holder, itemCount ->
                    with(holder.itemView) {
                        this.findViewById<TextView>(R.id.productNameText).text = item.name
                        this.findViewById<TextView>(R.id.categoryText).text = item.category
                        this.findViewById<ImageView>(R.id.productImage).load(item.imageFile) {
                            crossfade(100)
                        }
//                        this.findViewById<TextView>(R.id.sizeText).text = item.size.toString()
                        this.findViewById<TextView>(R.id.priceText).text = "$" + item.price.toString()
                    }
                }
            ) {}.apply {
                submitList(
                    products
                )
            }
        }
    }
}