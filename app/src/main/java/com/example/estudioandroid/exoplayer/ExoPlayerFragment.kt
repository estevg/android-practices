package com.example.estudioandroid.exoplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.annotation.OptIn
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.common.Player
import androidx.media3.common.util.UnstableApi
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.AspectRatioFrameLayout
import androidx.media3.ui.PlayerView
import com.example.estudioandroid.R
import com.example.estudioandroid.databinding.FragmentExoPlayerBinding


class ExoPlayerFragment : Fragment(R.layout.fragment_exo_player) {

    lateinit var binding: FragmentExoPlayerBinding
    private lateinit var playerView: PlayerView
    private lateinit var player: ExoPlayer

    @OptIn(UnstableApi::class) override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentExoPlayerBinding.bind(view)
        playerView = binding.playerView

        player = ExoPlayer.Builder(requireContext()).build()

        playerView.player = player
        playerView.resizeMode  = AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH


        // val videoUri = RawResourceDataSource.buildRawResourceUri(R.raw.favorite)
        // val mediaItem = MediaItem.fromUri(videoUri)


        val mediaItem = MediaItem.Builder()
            .setUri("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
            .setMimeType(MimeTypes.APPLICATION_MP4)
            .build()

        player.setMediaItem(mediaItem)
        player.repeatMode = Player.REPEAT_MODE_ALL
        player.prepare()
        player.play()

    }

    override fun onPause() {
        super.onPause()
        player.stop()
        player.release()
    }


}