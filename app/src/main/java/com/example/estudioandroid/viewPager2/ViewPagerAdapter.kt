package com.example.estudioandroid.viewPager2

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.estudioandroid.common.Board
import com.example.estudioandroid.core.BaseViewHolder
import com.example.estudioandroid.databinding.BoardItemBinding

class ViewPagerAdapter(
    private val boardList: List<Board>,
    private val onItemSelect: OnItemSelect
) :
    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnItemSelect {
        fun onClickListener(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            BoardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is BoardViewHolder -> holder.bin(boardList[position])
        }
    }

    override fun getItemCount(): Int = boardList.size

    private inner class BoardViewHolder(
        val binding: BoardItemBinding,
        val context: Context
    ) : BaseViewHolder<Board>(binding.root) {

        override fun bin(item: Board) {
            binding.container.background = ContextCompat.getDrawable(context, item.background)
            binding.ivImage.setImageResource(item.image)
            binding.txtTitle.text = item.title
            binding.txtSubtitle.text = item.description

            if (bindingAdapterPosition == boardList.size - 1) {
                binding.btnNext.text = "Finalizar"
            }

            binding.btnNext.setOnClickListener {
                onItemSelect.onClickListener(adapterPosition)
            }
        }
    }


}