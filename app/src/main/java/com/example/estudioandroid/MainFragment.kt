package com.example.estudioandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.estudioandroid.alertDialog.AlertDialogActivity
import com.example.estudioandroid.broadcastReceiver.BroadcastReceiver
import com.example.estudioandroid.camerax.FragmentCamerax
import com.example.estudioandroid.dataStore.DataStore
import com.example.estudioandroid.databinding.FragmentMainBinding
import com.example.estudioandroid.exoplayer.ExoPlayerFragment
import com.example.estudioandroid.mediaplayer.MediaPlayerFragment
import com.example.estudioandroid.navigateActivity.MainNavigate
import com.example.estudioandroid.permits.AuthorizationsFragment
import com.example.estudioandroid.services.ServiceActivity
import com.example.estudioandroid.sharedPreferences.SharedPreferences
import com.example.estudioandroid.superbase.MainActivitySuperBase
import com.example.estudioandroid.viewPager2.ViewPagerActivity
import com.example.estudioandroid.viewPagerWithVideo.ViewPagerWithVideoFragment


class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.ViewPager.setOnClickListener { navigateViewPager() }
        binding.btnSuperBase.setOnClickListener { navigateSuperBase() }
        binding.btnDialog.setOnClickListener { navigateDialog() }
        binding.btnBroadCastReceiver.setOnClickListener { navigateBroadCast() }
        binding.btnService.setOnClickListener { navigateService() }
        binding.dataStoreView.setOnClickListener { navigateDataStore() }
        binding.NavigateActivity.setOnClickListener { navigateActivity() }
        binding.sharedPreferences.setOnClickListener { navigateSharedPreferences() }
        binding.Perm.setOnClickListener { navigatePerm() }
        binding.camera.setOnClickListener { navigateCameraFragment() }
        binding.Video.setOnClickListener { navigateVideo() }
        binding.ViewPagerWithVideo.setOnClickListener { navigateViewPagerWithVideo() }
        binding.MediaPlayer.setOnClickListener { navigateMediaPlayer() }
    }


    private fun navigateMediaPlayer() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fragment_container_view, MediaPlayerFragment())
            addToBackStack(null)
        }
    }

    private fun navigateViewPagerWithVideo() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fragment_container_view, ViewPagerWithVideoFragment())
            addToBackStack(null)
        }
    }

    private fun navigateVideo() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fragment_container_view, ExoPlayerFragment())
            addToBackStack(null)
        }
    }

    private fun navigateCameraFragment() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fragment_container_view, FragmentCamerax())
            addToBackStack(null)
        }
    }


    private fun navigatePerm() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fragment_container_view, AuthorizationsFragment())
            addToBackStack(null)
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

    private fun navigateSharedPreferences() {
        startActivity(Intent(requireContext(), SharedPreferences::class.java))
    }

    private fun navigateActivity() {
        startActivity(Intent(requireContext(), MainNavigate::class.java))
    }
}