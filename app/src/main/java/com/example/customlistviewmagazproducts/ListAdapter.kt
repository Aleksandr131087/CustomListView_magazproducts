package com.example.customlistviewmagazproducts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter (context: Context, productlist: MutableList<Product>):
    ArrayAdapter<Product>(context, R.layout.list_iten, productlist)
{
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        var product = getItem(position)
if (view==null){
    view=LayoutInflater.from(context).inflate(R.layout.list_iten, parent, false)
}

val imageView = view?.findViewById<ImageView>(R.id.picture)
        val nameView = view?.findViewById<TextView>(R.id.ProductsNameETlist)
        val priceView = view?.findViewById<TextView>(R.id.priceETlist)

        imageView?.setImageBitmap(product?.image)
        nameView?.text = product?.nameproduct
        priceView?.text=product?.priceproduct

        return view!!
    }
}