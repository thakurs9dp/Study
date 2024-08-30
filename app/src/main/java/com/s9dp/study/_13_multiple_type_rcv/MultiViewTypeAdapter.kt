package com.s9dp.study._13_multiple_type_rcv

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.s9dp.study.R


class MultiViewTypeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private val itemList = mutableListOf<ListItems>()


    override fun getItemViewType(position: Int): Int {
        return when (itemList[position]) {
            is ListItems.Header -> R.layout.item_header
            is ListItems.ImageItems -> R.layout.item_image
            is ListItems.TextItem -> R.layout.item_text
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)

        return when (viewType) {
            R.layout.item_header -> HeaderViewHolder(view)
            R.layout.item_image -> ImageViewHolder(view)
            R.layout.item_text -> TextViewHolder(view)
            else -> throw IllegalArgumentException("Invalid view type")
        }

    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HeaderViewHolder -> holder.bind(itemList[position] as ListItems.Header)
            is ImageViewHolder -> holder.bind(itemList[position] as ListItems.ImageItems)
            is TextViewHolder -> holder.bind(itemList[position] as ListItems.TextItem)
        }
    }


    //ViewHolders of Header
    inner class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleTextView: TextView = itemView.findViewById(R.id.txtHeader)

        fun bind(header: ListItems.Header) {
            titleTextView.text = header.title
        }
    }

    //ViewHolders of Images
    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.rvImageView)

        fun bind(imgItems: ListItems.ImageItems) {
            imageView.setImageResource(imgItems.imageRes)
        }
    }

    //ViewHolders of Text
    inner class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val textView: TextView = itemView.findViewById(R.id.txtSubText)

        fun bind(textItem: ListItems.TextItem) {
            textView.text = textItem.txt
        }

    }


    // Method to update the list
    @SuppressLint("NotifyDataSetChanged")
    fun updateList(newItems: List<ListItems>) {
        itemList.clear()
        itemList.addAll(newItems)
        notifyDataSetChanged()
    }

    // Method to delete an item
    fun deleteItem(position: Int) {
        itemList.removeAt(position)
        notifyItemRemoved(position)
    }


}