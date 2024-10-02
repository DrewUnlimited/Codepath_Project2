package com.example.project2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var itemName: EditText
    private lateinit var itemPrice: EditText
    private lateinit var itemUrl: EditText
    private lateinit var addButton: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: WishlistAdapter
    private val wishlist = mutableListOf<WishlistItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        itemName = findViewById(R.id.itemName)
        itemPrice = findViewById(R.id.itemPrice)
        itemUrl = findViewById(R.id.itemUrl)
        addButton = findViewById(R.id.addButton)
        recyclerView = findViewById(R.id.recyclerView)

        // Initialize adapter and RecyclerView
        adapter = WishlistAdapter(wishlist)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set add button click listener
        addButton.setOnClickListener {
            addItem()
        }
    }

    private fun addItem() {
        // Get user input
        val name = itemName.text.toString()
        val price = itemPrice.text.toString().toDoubleOrNull() ?: 0.0
        val url = itemUrl.text.toString()

        // Add new item to the list
        val newItem = WishlistItem(name, price, url)
        wishlist.add(newItem)

        // Notify the adapter that data has changed
        adapter.notifyDataSetChanged()

        // Clear input fields
        itemName.text.clear()
        itemPrice.text.clear()
        itemUrl.text.clear()
    }
}
