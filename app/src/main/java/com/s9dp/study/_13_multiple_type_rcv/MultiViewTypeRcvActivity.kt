package com.s9dp.study._13_multiple_type_rcv

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.s9dp.study.R

class MultiViewTypeRcvActivity : AppCompatActivity() {

    private lateinit var rcvItems : RecyclerView
    private lateinit var adapter: MultiViewTypeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_view_type_rcv)
        rcvItems = findViewById(R.id.rcvItems)

        setRcv()
    }


    private fun setRcv() {

        adapter = MultiViewTypeAdapter()

        rcvItems.layoutManager = LinearLayoutManager(this)
        rcvItems.adapter = adapter

        val itemList = listOf(
            ListItems.Header("Header 1"),
            ListItems.ImageItems(R.drawable.ic_launcher_foreground),
            ListItems.TextItem("Text 1"),
            ListItems.TextItem("Text 1"),
            ListItems.TextItem("Text 1"),
            ListItems.TextItem("Text 1"),
            ListItems.TextItem("Text 1"),
            ListItems.TextItem("Text 1"),
            ListItems.TextItem("Text 1"),
            ListItems.TextItem("Text 1"),
            ListItems.Header("Header 2"),
            ListItems.ImageItems(R.drawable.ic_launcher_foreground),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
            ListItems.TextItem("Text 2"),
        )

        adapter.updateList(itemList)


        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(rcvItems)

    }

    private val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean = false

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            adapter.deleteItem(viewHolder.adapterPosition)
        }
    }


}