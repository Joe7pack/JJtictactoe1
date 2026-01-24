package com.guzzardo.jjtictactoe1

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

// ... other imports

@Composable
fun InteractiveCanvasWithItems(viewModel: MyViewModel = viewModel() ) {
    val circleCenter = Offset(200f, 200f)
    val circleRadius = 100f
    val myColor = viewModel.selectedColor
    Canvas(modifier = Modifier
        .fillMaxSize()
        .pointerInput(Unit) {
            detectTapGestures(
                onTap = { offset ->
                    // Perform hit testing
                    val distance = (offset - circleCenter).getDistance()
                    if (distance <= circleRadius) {
                        println("${myColor.toString()} circle clicked!")
                        // Call a specific handler function for the circle
                    }
                }
            )
        }
    ) {
        val canvasWidth = size.width
        val canvasHeight = size.height

        drawCircle(color = myColor, center = circleCenter, radius = circleRadius)
        //drawCircle(color = Color.Green, center = circleCenter, radius = circleRadius)
        // Draw other items and perform hit testing for them too
        val gameview = GameView(size.width, size.height, Color.Red, Color.Blue)
        //gameview.InitializeGame2(this, viewModel)  //move GameView to shared folder? And put GameView in a remember bracket?
        //TestImage()
        //InteractiveCanvasWithItems()
        //testNonComposable()
        //MultiplatformView()
    }
}



