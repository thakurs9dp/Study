package com.s9dp.study._0_permission_runtime_android

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.s9dp.study.R
import com.s9dp.study.decodeFile
import com.s9dp.study.hasPermissions
import com.s9dp.study.permissionGallery
import com.s9dp.study.utils.FileUtil
import java.util.ArrayList

class CameraAndGalleryActivity : AppCompatActivity() {

    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_and_gallery)
        initView()
    }

    private fun openGallery() {
        if (hasPermissions(permissionGallery)) {
            //Open Gallery fun
            galleryPicker()
        } else {
            requestMultiplePermissions(permissionGallery)
        }
    }


    private fun initView() {
        findViewById<Button>(R.id.btnGallery).setOnClickListener {
            openGallery()
        }
        imageView = findViewById(R.id.imgView)
    }


    private fun galleryPicker(isPickerTypeMultiple: Boolean = false) {
        val intent = Intent()
        intent.type = "video/*, image/*"
        val mimetypes = arrayOf("image/*", "video/*")
        intent.action = Intent.ACTION_GET_CONTENT
        if (isPickerTypeMultiple) {
            intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        }
        intent.putExtra(Intent.EXTRA_MIME_TYPES, mimetypes)
        pickGalleryImages.launch(intent)
    }


    private val pickGalleryImages =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                try {
                    val pics = ArrayList<Pics>()
                    // if multiple images are selected
                    if (data?.clipData != null) {
                        val count = data.clipData!!.itemCount
                        for (i in 0 until count) {

                            val imageUri: Uri = data.clipData!!.getItemAt(i).uri
                            val path = FileUtil.getPath(this, imageUri)
                            val imagePath = path?.let { it1 -> decodeFile(it1) }

                            imagePath?.let { it1 ->
                                val imageName = it1.substring(it1.lastIndexOf("/") + 1, it1.length)
                                pics.add(
                                    Pics(
                                        imageFile = imageUri.let {
                                            FileUtil.from(
                                                this, uri = it
                                            )
                                        },
                                        imageName = imageName.replaceAfterLast(".", "")
                                            .replace(".", "")
                                    )
                                )
                            }

                        }/* callback.pickerFiles(pics)
                        dismiss()*/

                        val fileName = pics.forEach {
                            it.imageFile

                            Log.d(
                                "FileValue",
                                "Mutiple ${it.imageFile} fileName ${it.imageName} ${it.notes}"
                            )

                        }


                    } else if (data?.data != null) {
                        // if single image is selected
                        val imageUri: Uri = data.data!!
                        val path = FileUtil.getPath(this, imageUri)
                        val imagePath = path?.let { it1 -> decodeFile(it1) }
                        imagePath?.let { it1 ->
                            val imageName = it1.substring(it1.lastIndexOf("/") + 1, it1.length)
                            pics.add(
                                Pics(
                                    imageFile = imageUri.let {
                                        FileUtil.from(
                                            this, uri = it
                                        )
                                    }, imageName = imageName
                                )
                            )
                        }/* callback.pickerFiles(pics)
                        dismiss()*/

                        val fileName = pics.forEach {
                            it.imageFile

                            Log.d(
                                "FileValue",
                                "FilePathIS ${it.imageFile} fileName ${it.imageName} ${it.notes}"
                            )

                        }

                        val bitmap = BitmapFactory.decodeFile(fileName.toString())
                        imageView.setImageBitmap(bitmap)

                        Log.d("FileValue", "FilePathIS $fileName")

                    }
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                    Toast.makeText(this, "Error ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }


    /**
     * Request the permission code -------------------------------------------------- ///
     */

    private val onActivityResultGalleryPermission =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { result ->
            //Open Gallery fun
            galleryPicker()
        }


    private fun requestMultiplePermissions(permissionsList: Array<String>) {
        val newPermissionStr = Array(permissionsList.size) { i ->
            permissionsList[i]
        }
        if (newPermissionStr.isNotEmpty()) {
            onActivityResultGalleryPermission.launch(newPermissionStr)
        } else {
            showSettingsDialog(requestPermissionLauncher)
        }
    }


    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {}


    private fun showSettingsDialog(resultLauncher: ActivityResultLauncher<Intent>) {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle("Need Permissions")
        builder.setMessage("This app needs permission to use this feature. You can grant them in app settings.")
        builder.setPositiveButton("GOTO SETTINGS") { dialog: DialogInterface, _: Int ->
            dialog.cancel()
            openSettings(resultLauncher)
        }
        builder.setNegativeButton("Cancel") { dialog: DialogInterface, _: Int -> dialog.cancel() }
        builder.show()
    }


    private fun openSettings(resultLauncher: ActivityResultLauncher<Intent>) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
        val uri = Uri.fromParts("package", packageName, null)
        intent.data = uri
        resultLauncher.launch(intent)
    }

    /**
     * Request Permission ---------------------------------------------------- ///
     */


}