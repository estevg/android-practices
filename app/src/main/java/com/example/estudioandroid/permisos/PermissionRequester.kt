package com.example.estudioandroid.permisos

import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment

class PermissionRequester(
    activity: Fragment,
    private val permission: String,
    onRationale: () -> Unit = {},
    onDenied: () -> Unit = {}
) {

    private var onGranted: () -> Unit = {}

    @RequiresApi(Build.VERSION_CODES.M)
    private val permissionLauncher =
        activity.registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            when {
                isGranted -> onGranted()
                activity.shouldShowRequestPermissionRationale(permission) -> onRationale()
                else -> onDenied()
            }
        }

    @RequiresApi(Build.VERSION_CODES.M)
    fun runWithPermission(body: () -> Unit) {
        onGranted = body
        permissionLauncher.launch(permission)
    }
}