package com.guzzardo.jjtictactoe1

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import jjtictactoe1.composeapp.generated.resources.Res
import jjtictactoe1.composeapp.generated.resources.compose_multiplatform
import jjtictactoe1.composeapp.generated.resources.favorites
import org.jetbrains.compose.resources.stringResource

@Composable
@Preview
fun App() {
    //We're only allowed 1 app!
    MaterialTheme {

        //val gamePlay = remember { GameView(20F, 20F, Color.Red, Color.Blue)}

        var showContent by remember { mutableStateOf(false) }
        //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        //val viewModel = viewModel<MyViewModel>()
        val viewModel: MyViewModel = viewModel { MyViewModel() } // Correct approach for KMP
        // per AI search result:
        //In KMP: Use collectAsState() directly within your shared UI code to trigger recomposition across all platforms.
        //val state by viewModel.state.collectAsStateWithLifecycle() //so this is Android only?
        val state by viewModel.state.collectAsState()
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }

                Column(
                    modifier = Modifier.fillMaxWidth(),

                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                    //Text("Window width: $minWidthDp")
                    //Text("Window height: $minHeightDp")
                    val resourceName = stringResource(Res.string.favorites)
                    //Text(text = resourceName)
                    //TestFun("joe")
                    //SampleNavigationSuiteScaffoldParts()
                    //KmpLineDrawingScreen()
                    //DrawingCanvas2()
                    //InteractiveCanvasWithItems()
                    //TestImage()
                    InteractiveCanvasWithItems(viewModel)

                }
            }
        }
    }
}








