package com.example.estudioandroid

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.estudioandroid.alertDialog.AlertDialogActivity
import com.example.estudioandroid.broadcastReceiver.BroadcastReceiver
import com.example.estudioandroid.camerax.FragmentCamerax
import com.example.estudioandroid.dataStore.DataStore
import com.example.estudioandroid.databinding.FragmentMainBinding
import com.example.estudioandroid.navigateActivity.MainNavigate
import com.example.estudioandroid.permisos.AuthorizationsFragment
import com.example.estudioandroid.permisos.PermissionRequester
import com.example.estudioandroid.services.ServiceActivity
import com.example.estudioandroid.sharedPreferences.SharedPreferences
import com.example.estudioandroid.superbase.MainActivitySuperBase
import com.example.estudioandroid.viewPager2.ViewPagerActivity


class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        val btnSharedPreferences = binding.sharedPreferences
        val btnNavigateActivity = binding.NavigateActivity
        val btnDataStore = binding.dataStoreView
        val btnServices = binding.btnService
        val btnBroadcastReceiver = binding.btnBroadCastReceiver
        val btnSuperBase = binding.btnSuperBase
        val btnDialog = binding.btnDialog
        val viewPager = binding.ViewPager
        val btnPerm = binding.Perm
        val btnCamera = binding.camera

        viewPager.setOnClickListener { navigateViewPager() }
        btnSuperBase.setOnClickListener { navigateSuperBase() }
        btnDialog.setOnClickListener { navigateDialog() }
        btnBroadcastReceiver.setOnClickListener { navigateBroadCast() }
        btnServices.setOnClickListener { navigateService() }
        btnDataStore.setOnClickListener { navigateDataStore() }
        btnNavigateActivity.setOnClickListener { navigateActivity() }
        btnSharedPreferences.setOnClickListener { navigateSharedPreferences() }
        btnPerm.setOnClickListener { navigatePerm() }
        btnCamera.setOnClickListener { navigateCameraFragment() }
    }

    private fun navigateCameraFragment() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fragment_container_view, FragmentCamerax())
            addToBackStack("camera")
        }
    }


    private fun navigatePerm() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fragment_container_view, AuthorizationsFragment())
            addToBackStack("permisos")
        }
    }

    private fun navigateViewPager() {
        startActivity(Intent(requireContext(), ViewPagerActivity::class.java))
    }

    private fun navigateDialog() {
        startActivity(Intent(requireContext(), AlertDialogActivity::class.java))
    }

    private fun navigateSuperBase() {
        startActivity(Intent(requireContext(), MainActivitySuperBase::class.java))
    }

    private fun navigateBroadCast() {
        startActivity(Intent(requireContext(), BroadcastReceiver::class.java))
    }

    private fun navigateService() {
        startActivity(Intent(requireContext(), ServiceActivity::class.java))
    }

    private fun navigateDataStore() {
        startActivity(Intent(requireContext(), DataStore::class.java))
    }

    private fun navigateSharedPreferences (){
        startActivity(Intent(requireContext(), SharedPreferences::class.java))
    }

    private fun navigateActivity (){
        startActivity(Intent(requireContext(), MainNavigate::class.java))
    }
}