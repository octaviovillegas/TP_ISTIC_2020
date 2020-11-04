package com.example.applicationlujita

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.gms.vision.barcode.Barcode
import devliving.online.mvbarcodereader.MVBarcodeScanner
import kotlinx.android.synthetic.main.activity_codigo_q_r.*

class CodigoQR : AppCompatActivity(), View.OnClickListener {
    private var b_auto: Button? = null
    private var b_manual: Button? = null
    private var b_multiple: Button? = null
    private var modo_Escaneo: MVBarcodeScanner.ScanningMode? = null
    private var text_cod_escaneado: TextView? = null
    private val CODE_SCAN = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_codigo_q_r)
        UI()
    }

    private fun UI() {
        b_auto = findViewById<View>(R.id.btn_m_auto) as Button
        b_manual = findViewById<View>(R.id.btn_m_manual) as Button
        b_multiple = findViewById<View>(R.id.btn_m_multiple) as Button
        text_cod_escaneado = findViewById<View>(R.id.cod_escaneo) as TextView
        b_auto!!.setOnClickListener(this)
        b_manual!!.setOnClickListener(this)
        b_multiple!!.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_m_auto -> modo_Escaneo = MVBarcodeScanner.ScanningMode.SINGLE_AUTO
            R.id.btn_m_manual -> modo_Escaneo = MVBarcodeScanner.ScanningMode.SINGLE_MANUAL
            R.id.btn_m_multiple -> modo_Escaneo = MVBarcodeScanner.ScanningMode.MULTIPLE
        }
        MVBarcodeScanner.Builder().setScanningMode(modo_Escaneo).setFormats(Barcode.ALL_FORMATS)
            .build()
            .launchScanner(this, CODE_SCAN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CODE_SCAN) {
            if (resultCode == Activity.RESULT_OK && data != null && data.extras != null) {
                if (data.extras!!.containsKey(MVBarcodeScanner.BarcodeObject)) {
                    val mBarcode: Barcode = data.getParcelableExtra(MVBarcodeScanner.BarcodeObject)
                    text_cod_escaneado!!.text = mBarcode.rawValue
                } else if (data.extras!!.containsKey(MVBarcodeScanner.BarcodeObjects)) {
                    val mBarcodes: List<Barcode> =
                        data.getParcelableArrayListExtra(MVBarcodeScanner.BarcodeObjects)
                    val s = StringBuilder()
                    for (b in mBarcodes) {
                        s.append(
                            """
    ${b.rawValue}

    """.trimIndent()
                        )
                    }
                    text_cod_escaneado!!.text = s.toString()
                    }
        }
    }

        buttonCont.setOnClickListener {

            val intent: Intent = Intent(this, PrecioProducto::class.java)
            startActivity(intent)
            finish()
        }
        buttonProducto.setOnClickListener {

            val intent: Intent = Intent(this, ListadoProductos::class.java)
            startActivity(intent)
            finish()
        }


    }
}
