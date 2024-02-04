
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RawRes
import androidx.core.content.ContextCompat
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.datasource.RawResourceDataSource
import androidx.media3.exoplayer.ExoPlayer
import androidx.recyclerview.widget.RecyclerView
import com.example.estudioandroid.R
import com.example.estudioandroid.common.Board
import com.example.estudioandroid.core.BaseViewHolder
import com.example.estudioandroid.databinding.BoardItemVideoBinding

class ViewPagerVideoAdapter(
    private val boardList: List<Board>,
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    private val players = mutableListOf<ViewPagerVideoAdapter.BoardViewHolder>()
    private var currentPlayingPosition: Int? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            BoardItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = BoardViewHolder(itemBinding, parent.context)
        players.add(holder)
        return holder
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is BoardViewHolder -> holder.bin(boardList[position])
        }
    }

    override fun getItemCount(): Int = boardList.size

    fun pausePlayer(position: Int) {
        currentPlayingPosition?.let { currentPosition ->
            if (currentPosition != position) {
                println("hola > $currentPosition y position $position")
                players[currentPosition].pausePlayer()
            }
        }

        currentPlayingPosition = position

        val mediaItem = MediaItem.Builder()
            .setUri(boardList[position].video)
            .setMimeType(MimeTypes.APPLICATION_MP4)
            .build()

        players[position].playPlayer(mediaItem)
    }

    fun pauseAllPlayers() {
        for (player in players) {
            player.pausePlayer()
        }
    }

    private inner class BoardViewHolder(
        val binding: BoardItemVideoBinding,
        val context: Context
    ) : BaseViewHolder<Board>(binding.root) {
        val player = ExoPlayer.Builder(context).build()


        override fun bin(item: Board) {
            binding.playerView.player = player
            binding.container.background = ContextCompat.getDrawable(context, item.background)
            binding.txtTitle.text = item.title
            binding.txtSubtitle.text = item.description
        }



        fun playPlayer(mediaItem: MediaItem) {
            player.setMediaItem(mediaItem)
            player.prepare()
            player.play()
        }

        fun pausePlayer() {
            player.pause()
        }
    }
}