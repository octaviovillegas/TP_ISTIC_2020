package com.example.ferretexapp.Infraestructure.Controller

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.ferretexapp.Infraestructure.Model.ImageController
import com.example.ferretexapp.Infraestructure.Model.Producto
import com.example.ferretexapp.R
import kotlinx.android.synthetic.main.item_producto.view.*

class ProductosAdapter(private val mContext: Context, private val listaProductos: List<Producto>) : ArrayAdapter<Producto>(mContext, 0, listaProductos) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layout = LayoutInflater.from(mContext).inflate(R.layout.item_producto, parent, false)

        val producto = listaProductos[position]

        layout.txtName.text = producto.nombre
        layout.txtPrice.text = "US$${producto.precio}"

        val imageUri = ImageController.getImageUri(mContext, producto.idProducto.toLong())

        layout.imageView.setImageURI(imageUri)

        return layout
    }

}