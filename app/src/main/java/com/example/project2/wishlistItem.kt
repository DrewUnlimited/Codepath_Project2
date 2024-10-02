package com.example.project2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class WishlistItem(
    val name: String,
    val price: Double,
    val url: String
)
class WishlistAdapter(private val wishlist: List<WishlistItem>) :
    RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder>() {

    inner class WishlistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val priceTextView: TextView = itemView.findViewById(R.id.priceTextView)
        private val urlTextView: TextView = itemView.findViewById(R.id.urlTextView)

        fun bind(item: WishlistItem) {
            nameTextView.text = item.name
            priceTextView.text = item.price.toString()
            urlTextView.text = item.url
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.wishlist_item, parent, false)
        return WishlistViewHolder(view)
    }

    override fun onBindViewHolder(holder: WishlistViewHolder, position: Int) {
        holder.bind(wishlist[position])
    }

    override fun getItemCount(): Int = wishlist.size
}
