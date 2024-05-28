package com.example.firstapp

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FolderViewModel : ViewModel() {
    private val _folderItems = MutableLiveData<List<Pair<Uri, String>>>()
    val folderItems: LiveData<List<Pair<Uri, String>>> = _folderItems

    init {
        loadFolderItems()
    }

    private fun loadFolderItems() {
        // Load folder items from repository or any other source
        val items = listOf(
            Pair(Uri.parse("android.resource://com.example.firstapp/"+R.drawable.folder1), "Category Name"),
            Pair(Uri.parse("android.resource://com.example.firstapp/"+R.drawable.folder1), "Category Name"),
            Pair(Uri.parse("android.resource://com.example.firstapp/"+R.drawable.folder1), "Category Name"),
            Pair(Uri.parse("android.resource://com.example.firstapp/"+R.drawable.folder1), "Category Name"),
            Pair(Uri.parse("android.resource://com.example.firstapp/"+R.drawable.folder1), "Category Name"),
            // Add more items as needed
        )
        _folderItems.value = items
    }
}