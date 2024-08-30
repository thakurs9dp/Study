package com.s9dp.study

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.READ_MEDIA_IMAGES
import android.Manifest.permission.READ_MEDIA_VIDEO
import android.Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED
import android.os.Build
import android.os.Build.VERSION.SDK_INT


val permissionGallery = when {

    SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE -> {
        arrayOf(READ_MEDIA_VISUAL_USER_SELECTED)
    }

    SDK_INT >= Build.VERSION_CODES.TIRAMISU -> {
        arrayOf(READ_MEDIA_VIDEO, READ_MEDIA_IMAGES)
    }

    else -> {
        arrayOf(READ_EXTERNAL_STORAGE)
    }

}