package com.example.estudioandroid.viewPagerWithVideo

import ViewPagerVideoAdapter
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.estudioandroid.R
import com.example.estudioandroid.common.Board
import com.example.estudioandroid.databinding.FragmentViewPagerWithVideoBinding


class ViewPagerWithVideoFragment : Fragment(R.layout.fragment_view_pager_with_video) {

    private lateinit var boardList: List<Board>
    private lateinit var binding: FragmentViewPagerWithVideoBinding
    private lateinit var viewPagerVideoAdapter: ViewPagerVideoAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentViewPagerWithVideoBinding.bind(view)

        boardList = listOf(
            Board(
                background = R.color.teal_200,
                image = R.drawable.ic_launcher_foreground,
                title = "Lorem ipsum",
                description = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor",
                video = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"
            ),
            Board(
                background = R.color.red400,
                image = R.drawable.ic_launcher_foreground,
                title = "Lorem ipsum",
                description = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor",
                video = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"
            ),
            Board(
                background = R.color.teala200,
                image = R.drawable.ic_launcher_foreground,
                title = "Lorem ipsum",
                description = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor",
                video = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4"
            ),
            Board(
                background = R.color.yellowa200,
                image = R.drawable.ic_launcher_foreground,
                title = "Lorem ipsum",
                description = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor",
                video = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4"
            ),
            Board(
                background = R.color.deeporangea400,
                image = R.drawable.ic_launcher_foreground,
                title = "Lorem ipsum",
                description = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor",
                video = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"
            )
        )

        viewPagerVideoAdapter = ViewPagerVideoAdapter(boardList)
        binding.viewPager.adapter = viewPagerVideoAdapter

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewPagerVideoAdapter.pausePlayer(position)
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewPagerVideoAdapter.pauseAllPlayers()
    }


}