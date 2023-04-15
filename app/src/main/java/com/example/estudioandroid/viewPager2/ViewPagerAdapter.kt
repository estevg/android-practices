package com.example.estudioandroid.viewPager2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.estudioandroid.core.BaseViewHolder
import com.example.estudioandroid.databinding.BoardItemBinding

class ViewPagerAdapter(
    private val boardList: List<Board>,
    private val onItemSelect: OnItemSelect
):
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnItemSelect {
        fun onClickListener(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = BoardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is BoardViewHolder -> holder.bin(boardList[position])
        }
    }

    override fun getItemCount(): Int = boardList.size

    private inner class BoardViewHolder(
        binding: BoardItemBinding,
        val context: Context
    ): BaseViewHolder<Board>(binding.root){
        private val container = binding.container
        private val image = binding.ivImage
        private val title = binding.txtTitle
        private val description = binding.txtSubtitle
        private val button = binding.btnNext


        override fun bin(item: Board) {
            container.background = ContextCompat.getDrawable(context, item.background)
            image.setImageResource(item.image)
            title.text = item.title
            description.text = item.description

            if (adapterPosition == boardList.size - 1){
                button.text = "Finalizar"
            }

            button.setOnClickListener {
                onItemSelect.onClickListener(adapterPosition)
            }
        }
    }



}