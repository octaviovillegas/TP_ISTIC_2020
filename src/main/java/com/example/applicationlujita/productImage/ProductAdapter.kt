package com.example.applicationlujita.productImage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.applicationlujita.R
import kotlinx.android.synthetic.main.product_items.view.*

class ProductAdapter(private val mContext: Context, private val listaProductos: List<Producto>) : ArrayAdapter<Producto>(mContext, 0, listaProductos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.product_items, parent, false)

        val producto = listaProductos[position]

        layout.nombre.text = producto.nombre
        layout.precio.text = "$${producto.precio}"

        val imageUri = ImageController.getImageUri(mContext, producto.idProducto.toLong())

        layout.imageView.setImageURI(imageUri)

        return layout
    }

}