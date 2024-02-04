package com.example.estudioandroid.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.estudioandroid.R
import com.example.estudioandroid.databinding.FragmentMediaPlayerBinding


class MediaPlayerFragment : Fragment(R.layout.fragment_media_player) {

    lateinit var binding: FragmentMediaPlayerBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMediaPlayerBinding.bind(view)

       val listButton = mapOf<View, Int>(
           binding.vwDrum1 to R.raw.kick,
           binding.vwDrum2 to R.raw.high_tom,
           binding.vwDrum3 to R.raw.low_tom,
           binding.vwDrum4 to R.raw.kick,
           binding.vwDrum5 to R.raw.medium_tom,
           binding.vwDrum6 to R.raw.hihat_cl,
       )

        listButton.forEach { (view, audio) ->
            run {
                view.setOnClickListener { value ->
                    val mediaPlayer = MediaPlayer.create(requireContext(), audio)
                    mediaPlayer.setOnCompletionListener {
                        value.background.alpha = 255
                    }
                    mediaPlayer.start()
                    value.background.alpha = 128
                }
            }
        }
    }
}