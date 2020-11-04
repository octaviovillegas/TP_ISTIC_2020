package com.example.applicationlujita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_view.*

class ViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        var modalItems: Modal = intent.getSerializableExtra("data") as Modal;

        Log.e("name",modalItems.name);

        viewName.text = modalItems.name;
        viewImage.setImageResource(modalItems.image!!);
    }
}
