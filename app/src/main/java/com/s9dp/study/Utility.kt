package com.s9dp.study

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.s9dp.study.utils.ScalingUtilities
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream

private var alertDialog: AlertDialog? = null


fun Fragment.hasPermissions(permissions: Array<String>) = permissions.all {
    activity?.let { it1 ->
        ContextCompat.checkSelfPermission(
            it1, it
        )
    } == PackageManager.PERMISSION_GRANTED
}


fun Activity.hasPermissions(permissions: Array<String>): Boolean {
    return permissions.all {
        ContextCompat.checkSelfPermission(
            this, it
        ) == PackageManager.PERMISSION_GRANTED
    }
}

 fun Activity.decodeFile(
    path: String
): String {
    var strMyImagePath: String? = null
    val scaledBitmap: Bitmap?
    try {
        // Part 1: Decode image
        val unscaledBitmap = ScalingUtilities.decodeFile(
            path,
            800,
            800,
            ScalingUtilities.ScalingLogic.FIT
        )
        scaledBitmap =
            if (!(unscaledBitmap.width <= 800 && unscaledBitmap.height <= 800)) {
                // Part 2: Scale image
                ScalingUtilities.createScaledBitmap(
                    unscaledBitmap,
                    800,
                    800,
                    ScalingUtilities.ScalingLogic.FIT
                )
            } else {
                unscaledBitmap.recycle()
                return path
            }

        // Store to tmp file
        val externalFilesDir = getExternalFilesDir(null)!!.absolutePath
        val mFolder = File("$externalFilesDir/TMMFOLDER")
        if (!mFolder.exists()) {
            mFolder.mkdir()
        }
        val s = "tmp.png"
        val f = File(mFolder.absolutePath, s)
        strMyImagePath = f.absolutePath
        val fos: FileOutputStream?
        try {
            fos = FileOutputStream(f)
            scaledBitmap.compress(Bitmap.CompressFormat.JPEG, 75, fos)
            fos.flush()
            fos.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        scaledBitmap.recycle()
    } catch (e: Throwable) {
        Log.d("Catch", "Exception ${e.message}")
    }
    return strMyImagePath ?: path
}


