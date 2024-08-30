package com.s9dp.study._0_permission_runtime_android

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.File


@Parcelize
data class Pics(
    val imageFile: File? = null, val imageName: String? = null, var notes: String? = null
) : Parcelable
