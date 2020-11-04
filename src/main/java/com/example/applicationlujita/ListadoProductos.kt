package com.example.applicationlujita

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_listado_productos.*

class ListadoProductos : AppCompatActivity() {

    var modalList = ArrayList<Modal>()

    var names = arrayOf(
        "Imagine $180",
        "Libro Mickey $250",
        "Rallado Colores $130",
        "ABC $250",
        "Avon $150",
        "Estrella $200",
        "Oxford rojo $400",
        "Campus $270",
        "Oxford $210",
        "Oxford black $380"
    )

    var images = intArrayOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_productos)

        for (i in names.indices){
            modalList.add(Modal(names[i], images[i]))
        }

        var customerAdapter = CustomerAdapter(modalList, this)

        gridView.adapter = customerAdapter;

        gridView.setOnItemClickListener{ adapterView, view, i, l ->
            var intent =Intent(this, ViewActivity::class.java)
            intent.putExtra("data",modalList[i])
            startActivity(intent);
        }


    }

    class CustomerAdapter(
        var itemModel: ArrayList<Modal>,
        var context: Context
    ) : BaseAdapter(){

        var layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
            var view= view;
            if(view == null){
                view = layoutInflater.inflate(R.layout.row_items,viewGroup, false)
            }

            var tvImageName = view?.findViewById<TextView>(R.id.imageName)
            var imageView = view?.findViewById<ImageView>(R.id.imageView);

            tvImageName?.text =itemModel[position].name;
            imageView?.setImageResource(itemModel[position].image!!)

            return view!!;
        }

        override fun getItem(p0: Int): Any {
            return itemModel[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return itemModel.size
        }


    }
}
