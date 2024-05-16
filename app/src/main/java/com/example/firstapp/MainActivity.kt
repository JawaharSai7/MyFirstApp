package com.example.firstapp

import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val folderViewModel: FolderViewModel by viewModels()
    private val secondViewModel: SecondViewModel by viewModels()
    private val notebookViewModel: NotebookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerViews()

        // Observe LiveData
        observeFolderItems()
        observeSecondItems()
        observeNotebookItems()
    }

    private fun setupRecyclerViews() {
        // Set up RecyclerViews for Folder
        binding.recyclerViewCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        // Set up RecyclerViews for Second
        binding.recyclerViewSecond.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        // Set up RecyclerViews for Notebook
        binding.recyclerViewNotebook.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun observeFolderItems() {
        folderViewModel.folderItems.observe(this, { folderItems ->
            // Update RecyclerView with folderItems
            val folderAdapter = FolderAdapter(folderItems)
            binding.recyclerViewCategories.adapter = folderAdapter
        })
    }

    private fun observeSecondItems() {
        secondViewModel.secondItems.observe(this, { secondItems ->
            // Update RecyclerView with secondItems
            val secondAdapter = SecondAdapter(secondItems)
            binding.recyclerViewSecond.adapter = secondAdapter
        })
    }

    private fun observeNotebookItems() {
        notebookViewModel.notebookItems.observe(this, { notebookItems ->
            // Update RecyclerView with notebookItems
            val notebookAdapter = NotebookAdapter(notebookItems)
            binding.recyclerViewNotebook.adapter = notebookAdapter
        })
    }
}
