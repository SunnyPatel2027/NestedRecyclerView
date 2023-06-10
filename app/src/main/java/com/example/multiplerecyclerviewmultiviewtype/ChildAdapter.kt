package com.example.multiplerecyclerviewmultiviewtype

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.multiplerecyclerviewmultiviewtype.databinding.RecordCardBinding
import com.example.multiplerecyclerviewmultiviewtype.databinding.WebCardBinding

class ChildAdapter(private val viewType: Int, private val recyclerItemList1: List<RecyclerItem1>?, private val recyclerItemList2: List<RecyclerItem2>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class BestSellerViewHolder(private val binding: RecordCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindBestSellerView(recyclerItem: RecyclerItem1,position: Int) {
            binding.daysText.text =recyclerItem.days
            binding.lessonText.text = recyclerItem.lesson
            binding.chalText.text = recyclerItem.challenges
            if(position%2 != 0) {
                binding.recordView.setCardBackgroundColor(Color.GREEN)
            }
            binding.recordView.setOnClickListener{
                Toast.makeText(binding.root.context,"You select ${recyclerItem.days} card.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    inner class ClothingViewHolder(private val binding: WebCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindClothingView(recyclerItem: RecyclerItem2, position: Int) {
            binding.clothingImage.setImageResource(recyclerItem.image)
            binding.timeText.text = recyclerItem.time
            binding.titleText.text = recyclerItem.title

            binding.webCardView.setOnClickListener{
                Toast.makeText(binding.root.context,"You select ${recyclerItem.title} ${position+1} item.",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            DataItemType.RECORD_CARD -> {
                val binding = RecordCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return BestSellerViewHolder(binding)
            }
            else -> {
                val binding = WebCardBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return ClothingViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return recyclerItemList1?.size ?: recyclerItemList2!!.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {

            is BestSellerViewHolder -> {
                holder.bindBestSellerView(recyclerItemList1!![position], position)

            }

            is ClothingViewHolder -> {
                holder.bindClothingView(recyclerItemList2!![position], position)
            }
        }
    }
}