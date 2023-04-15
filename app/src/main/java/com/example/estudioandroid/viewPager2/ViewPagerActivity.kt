package com.example.estudioandroid.viewPager2

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.estudioandroid.R
import com.example.estudioandroid.databinding.ActivityViewPagerBinding

class ViewPagerActivity : AppCompatActivity(), ViewPagerAdapter.OnItemSelect {

    lateinit var binding: ActivityViewPagerBinding

    private lateinit var boardList: List<Board>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }


        boardList = listOf(
            Board(
                background = R.color.teal_200,
                image = R.drawable.ic_launcher_foreground,
                title = "Lorem ipsum",
                description = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor"
            ),
            Board(
                background = R.color.red400,
                image = R.drawable.ic_launcher_foreground,
                title = "Lorem ipsum",
                description = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor"
            ),
            Board(
                background = R.color.teala200,
                image = R.drawable.ic_launcher_foreground,
                title = "Lorem ipsum",
                description = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor"
            ),
            Board(
                background = R.color.yellowa200,
                image = R.drawable.ic_launcher_foreground,
                title = "Lorem ipsum",
                description = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor"
            ),
            Board(
                background = R.color.deeporangea400,
                image = R.drawable.ic_launcher_foreground,
                title = "Lorem ipsum",
                description = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor"
            )
        )

        val viewPager = binding.viewPager

        viewPager.adapter = ViewPagerAdapter(boardList, this@ViewPagerActivity)
        /*viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL*/
        /*viewPager.layoutDirection = ViewPager2.LAYOUT_DIRECTION_INHERIT*/
    }

    override fun onClickListener(position: Int) {
        if (position == (boardList.size - 1)) {
            Toast.makeText(this, "Llego al final", Toast.LENGTH_SHORT).show()
        } else {
            binding.viewPager.setCurrentItem((position + 1), true)
        }
    }
}