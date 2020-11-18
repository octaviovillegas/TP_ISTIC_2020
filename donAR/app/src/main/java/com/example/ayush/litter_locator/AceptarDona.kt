package com.example.food_locator

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.view.View
import android.widget.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.food_locator.Datahelper.car.foodHuri


class AceptarDona : AppCompatActivity() {



    var dbfood: AppDatabase= AppDatabase(this,"nombre",null,1)
    var Hclass: Datahelper? = null
    var camera_btn: ImageButton? = null
    var addPhoto: Button? = null
    val REQUEST_TAKE_PHOTO = 1
    val GALLERY = 2
    object tran{
        var picUri: Uri?=null
    }
    var backimg : ImageView?= null
    var dropdown: Spinner? = null
    var fImageView: FrameLayout?=null
    var FImage: ImageView?=null
    var cameraUri: Uri?= null
    var ta: EditText? = null
    var typefood: Button? = null
    var mCurrentPhotoPath: String? = null
    var gallery_btn: ImageButton? = null
    var submit: Button? = null
    var mLocation: EditText? = null
    var down_btn: ImageButton? = null
    var food_photo: ImageView? = null
    var addPhotoimg: RelativeLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_food)

        addPhoto = findViewById(R.id.addPhoto)
        mLocation = findViewById(R.id.locationBtn)
        gallery_btn = findViewById(R.id.gallery_btn)
        camera_btn = findViewById(R.id.camera_btn)
        submit = findViewById(R.id.submitBtn)
        down_btn = findViewById(R.id.down_btn)
        food_photo = findViewById(R.id.selected_pic)
        backimg = findViewById(R.id.back)
        addPhotoimg = findViewById(R.id.cho_photo)
        ta = findViewById(R.id.editText)
        fImageView = findViewById(R.id.fillImgView)
        FImage = findViewById(R.id.fullImage)

         dropdown = findViewById(R.id.spinner1)
//create a list of items for the spinner.
        var items = arrayOf("Congelados", "Crudos", "Cocinados", "No Perecederos","Líquidos")
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)
        dropdown?.adapter = adapter



        dropdown?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var textsp = dropdown?.selectedItem.toString()
                Datahelper.car.foodHtype = textsp
            }

        }








        submit?.setOnClickListener({
            val info= ta?.text.toString()
            Datahelper.car.foodHinfo = info
            val loc = mLocation?.text.toString()
            Datahelper.car.foodHloc = loc
            if(tran.picUri != null){
                Datahelper.car.foodHuri = tran.picUri.toString()


             //   Datahelper.car.ttr = "nombre"
                dbfood.storeData(Datahelper.car.foodHtype,Datahelper.car.foodHinfo,Datahelper.car.foodHloc,Datahelper.car.foodHuri,Datahelper.car.foodHname)
              //  Toast.makeText(this@Uploadfood,Datahelper.car.ttr,Toast.LENGTH_LONG).show()


                var mint:Intent ?= null
                mint= Intent(this@AceptarDona,SucessActivity::class.java)
                startActivity(mint)
            }else{
                Toast.makeText(this@AceptarDona,"Suba la imagen",Toast.LENGTH_SHORT).show()
            }
        })
        addPhoto?.setOnClickListener({
            mLocation?.visibility = View.INVISIBLE
            submit?.visibility = View.INVISIBLE
            addPhoto?.visibility = View.INVISIBLE
            addPhotoimg?.visibility = View.VISIBLE
        })
        down_btn?.setOnClickListener({
            mLocation?.visibility = View.VISIBLE
            submit?.visibility = View.VISIBLE
            addPhoto?.visibility = View.VISIBLE
            addPhotoimg?.visibility = View.INVISIBLE
        })
        camera_btn?.setOnClickListener({
            dispatchTakePictureIntent()
            galleryAddPic()
        })
        gallery_btn?.setOnClickListener({
            choosepicFromGallery()
        })
        food_photo?.setOnClickListener({
            fImageView?.visibility = View.VISIBLE
            if(tran.picUri != null)
                FImage?.setImageURI(tran.picUri)
            else{
                FImage?.setBackgroundResource(R.drawable.logo)
            }
            food_photo?.visibility = View.INVISIBLE
            addPhoto?.visibility = View.INVISIBLE
            submit?.visibility = View.INVISIBLE
            mLocation?.visibility = View.INVISIBLE
            ta?.visibility = View.INVISIBLE
            typefood?.visibility = View.INVISIBLE

        })
        backimg?.setOnClickListener({
            fImageView?.visibility = View.INVISIBLE
            food_photo?.visibility = View.VISIBLE
            addPhoto?.visibility = View.VISIBLE
            submit?.visibility = View.VISIBLE
            mLocation?.visibility = View.VISIBLE
            ta?.visibility = View.VISIBLE
            typefood?.visibility = View.VISIBLE

        })
    }

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            mCurrentPhotoPath = absolutePath
        }
    }


    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    // Error occurred while creating the File
                    Toast.makeText(this@AceptarDona, "El problema está aquí", Toast.LENGTH_SHORT).show()
                    this.finish()
                    null
                }

                // Continue only if the File was successfully created
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        "com.example.food_locator",
                        it
                    )
                    cameraUri = photoURI
                    tran.picUri = photoURI
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)

                }
            }
        }
    }

    private fun galleryAddPic() {
        Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE).also { mediaScanIntent ->
            val f = File(mCurrentPhotoPath)
            mediaScanIntent.data = Uri.fromFile(f)
            sendBroadcast(mediaScanIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, InUri: Intent?) {
        super.onActivityResult(requestCode, resultCode, InUri)
        if (requestCode == REQUEST_TAKE_PHOTO) {
            if (cameraUri != null){
                food_photo?.setImageURI(cameraUri)
                Toast.makeText(this@AceptarDona,"Imagen Subida Correctamente", Toast.LENGTH_SHORT).show()
                mLocation?.visibility = View.VISIBLE
                submit?.visibility = View.VISIBLE
                addPhoto?.visibility = View.VISIBLE
                addPhotoimg?.visibility = View.INVISIBLE
            }

        }
        if(requestCode == GALLERY){
            if (InUri != null) {
                val contentURI = InUri.data
                tran.picUri = contentURI
                try {
                    Toast.makeText(this@AceptarDona, "Imagen Subida Correctamente!", Toast.LENGTH_SHORT).show()
                    food_photo?.setImageURI(contentURI)
                    mLocation?.visibility = View.VISIBLE
                    submit?.visibility = View.VISIBLE
                    addPhoto?.visibility = View.VISIBLE
                    addPhotoimg?.visibility = View.INVISIBLE
                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this@AceptarDona, "Intento fallido!", Toast.LENGTH_SHORT).show()
                }

            }
        }


    }

    fun choosepicFromGallery(){
        val galleryIntent = Intent(
            Intent.ACTION_PICK,
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )

        startActivityForResult(galleryIntent, GALLERY)
    }


}