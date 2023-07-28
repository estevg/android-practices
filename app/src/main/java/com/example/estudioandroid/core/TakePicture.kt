package com.example.estudioandroid.core

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

class TakePicture(activity: Fragment) {

    private var onGranted: (imageBitmap: Bitmap) -> Unit = {}

    private val responseLauncher =
        activity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            if (activityResult.resultCode == Activity.RESULT_OK) {
                activityResult.data?.extras?.let { result ->
                    val imageBitMap = result.get("data") as Bitmap
                    onGranted(imageBitMap)
                }
            }
        }

    fun onDispatchCamera(body: (imageBitmap: Bitmap) -> Unit) {
        onGranted = body
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            responseLauncher.launch(takePictureIntent)
        } catch (e: ActivityNotFoundException) {
            Log.d("Error Camera", "Error Camera")
        }
    }
}