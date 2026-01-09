package com.guzzardo.jjtictactoe1

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.jetbrains.compose.resources.stringArrayResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.Text

@Composable
fun MyScreen(viewModel: MyViewModel = viewModel { MyViewModel() }) {
    // Observe the resource reference from ViewModel
    val arrayResource by viewModel.currentArray.collectAsState()

    // Resolve the actual list of strings from the resource
    val items: List<String> = stringArrayResource(arrayResource)

    LazyColumn {
        items(items) { text ->
            Text(text)
        }
    }
}