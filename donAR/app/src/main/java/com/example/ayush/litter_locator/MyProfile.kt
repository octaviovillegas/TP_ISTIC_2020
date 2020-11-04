package com.example.food_locator

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class MyProfile : AppCompatActivity() {
    var dp:ImageView?=null
    val GALLERY =1
    var dpname:TextView?=null
    var db : AppDatabase = AppDatabase(this,"nombre",null,1)
    var dppoints:TextView?=null
    var cdp:Button?= null
    var cameraUri: Uri?= null
    var mCurrentPhotoPath: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_profile)
        dp = findViewById(R.id.ppic)
        dpname = findViewById(R.id.dpname)
        dppoints = findViewById(R.id.pnts)
        dpname?.setText(Datahelper.car.foodHname)
       db.qfun()
        val txt = "Puntos: "+Datahelper.car.pnts
        dppoints?.setText(txt)


      Datahelper.car.ttr = "nombre"
        db.qpic()
        val ch = Datahelper.car.picuri
       if (ch!=null){
           var pu = Uri.parse(ch)
        dp?.setImageURI(pu)
       //    Toast.makeText(this,Datahelper.car.ttr,Toast.LENGTH_SHORT).show()
       }


        cdp = findViewById(R.id.changedp)
        cdp?.setOnClickListener {
//            val galleryIntent = Intent(
//                Intent.ACTION_PICK,
//                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
//            )
//
//            startActivityForResult(galleryIntent, GALLERY)
//            db.storePic(Datahelper.car.foodHname,Datahelper.car.picuri)
            dispatchTakePictureIntent()

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == GALLERY){
            if (cameraUri != null){
            dp?.setImageURI(cameraUri)
                Datahelper.car.picuri = cameraUri.toString()
                db.storePics(Datahelper.car.foodHname, Datahelper.car.picuri)
            }
        }
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
                    Toast.makeText(this, "Hay un Problema", Toast.LENGTH_SHORT).show()
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
                    Uploadfood.tran.picUri = photoURI
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, GALLERY)

                }
            }
        }
    }
}
