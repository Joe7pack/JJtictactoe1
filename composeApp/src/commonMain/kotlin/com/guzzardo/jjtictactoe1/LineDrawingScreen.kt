package com.guzzardo.jjtictactoe1

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap

@Composable
fun KmpLineDrawingScreen() {
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasWidth = size.width
        val canvasHeight = size.height
        // Draw a diagonal line from top-right to bottom-left
        drawLine(
            start = Offset(x = canvasWidth, y = 0f),
            end = Offset(x = 0f, y = canvasHeight),
            color = Color.Blue, // Use Color for styling
            strokeWidth = 5f, // Specify the line thickness
            cap = StrokeCap.Round // Optional: defines the cap style
        )
    }
}
