package com.example.firstapp

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotebookViewModel : ViewModel() {
    private val _notebookItems = MutableLiveData<List<Pair<Uri, String>>>()
    val notebookItems: LiveData<List<Pair<Uri, String>>> = _notebookItems

    init {
        loadNotebookItems()
    }

    private fun loadNotebookItems() {
        // Load notebook items from repository or any other source
        val items = listOf(
            Pair(Uri.parse("android.resource://com.example.firstapp/"+R.drawable.page), "Notebook Name")
            // Add more items as needed
        )
        _notebookItems.value = items
    }
}