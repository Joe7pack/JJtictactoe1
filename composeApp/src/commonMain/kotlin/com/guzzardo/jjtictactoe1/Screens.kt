package com.guzzardo.jjtictactoe1

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.jetbrains.compose.resources.stringArrayResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MyScreen(viewModel: MyViewModel = viewModel { MyViewModel() }) {
    // Observe the resource reference from ViewModel
    val arrayResource by viewModel.currentArray.collectAsState()

    // Resolve the actual list of strings from the resource
    val items: List<String> = stringArrayResource(arrayResource)

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        //items(items) { text -> Text(text)

        items(items) { item ->
            // Each item in the list can have its own Button
            Button(
                onClick = {
                    // Handle button click for this specific item
                    println("Button clicked for item: $item")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) { Text(item)
            }
        }
    }
}