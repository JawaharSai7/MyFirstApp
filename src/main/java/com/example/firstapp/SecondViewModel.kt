package com.example.firstapp

// SecondViewModel.kt
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {
    private val _secondItems = MutableLiveData<List<Pair<Uri, String>>>()
    val secondItems: LiveData<List<Pair<Uri, String>>> = _secondItems

    init {
        loadSecondItems()
    }

    private fun loadSecondItems() {
        // Load second items from repository or any other source
        val items = listOf(
            Pair(Uri.parse("android.resource://com.example.firstapp/"+R.drawable.notebook1), "Name"),
            Pair(Uri.parse("android.resource://com.example.firstapp/"+R.drawable.notebook2), "Name"),
            Pair(Uri.parse("android.resource://com.example.firstapp/"+R.drawable.notebook1), "Name"),
            Pair(Uri.parse("android.resource://com.example.firstapp/"+R.drawable.notebook1), "Name"),
            Pair(Uri.parse("android.resource://com.example.firstapp/"+R.drawable.notebook2), "Name")
            // Add more items as needed
        )
        _secondItems.value = items
    }
}