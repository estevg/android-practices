package com.example.estudioandroid.permits

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.estudioandroid.R
import com.example.estudioandroid.core.TakePicture
import com.example.estudioandroid.core.openAppSetting
import com.example.estudioandroid.databinding.FragmentAuthorizationsBinding

class AuthorizationsFragment : Fragment(R.layout.fragment_authorizations) {

    lateinit var binding: FragmentAuthorizationsBinding

    private val dispatchTakePicture = TakePicture(this)


    private val getPermission = PermissionRequester(this, Manifest.permission.CAMERA, onDenied = {
        Toast.makeText(requireContext(), "Denied", Toast.LENGTH_SHORT).show()
        requireContext().openAppSetting()
    }, onRationale = {
        Toast.makeText(requireContext(), "Rational", Toast.LENGTH_SHORT).show()
    })

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAuthorizationsBinding.bind(view)
        binding.btnPerm.setOnClickListener {
            getPermission.runWithPermission {
                Toast.makeText(requireContext(), "Granted", Toast.LENGTH_SHORT).show()
                dispatchTakePicture.onDispatchCamera {

                }
            }
        }

    }

}