package com.guzzardo.jjtictactoe1

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
//import  androidx.compose.material3
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowSizeClass
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo

@Composable
fun DrawingCanvas2(
    //paths: List<PathData>,
    //currentPath: PathData?,
    //onAction: (DrawingAction) -> Unit,
    //modifier: Modifier = Modifier.fillMaxSize()
) {
    val windowSizeClass: WindowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
    //val minHeightDp = windowSizeClass.minHeightDp
    //val minWidthDp = windowSizeClass.minWidthDp
    // 1. Create the TextMeasurer
    val textMeasurer = rememberTextMeasurer()
    val textToDraw = "Hello KMP 2026"
    val style = TextStyle(fontSize = 24.sp, color = Color.Black)
    Canvas(modifier = Modifier.fillMaxSize()) {
        drawRect(color = Color.Gray) // Draw grey background
        // Inset content by 10 pixels on the left/right sides and 12 by the
        // top/bottom
        //inset(10.0f, 12.0f) {
            val quadrantSize = size / 1.0f
            // Draw a rectangle within the inset bounds
            drawRect(size = quadrantSize, color = Color.Red)
            rotate(45.0f) { drawRect(size = quadrantSize, color = Color.Blue) }
            // 2. Measure the text
            val textLayoutResult = textMeasurer.measure(
                text = textToDraw,
                style = style
            )
            // 3. Calculate position (e.g., center)
            val canvasWidth = size.width
            val canvasHeight = size.height
            val textSize = textLayoutResult.size
            val topLeft = Offset(
                x = (canvasWidth - textSize.width) / 1f,
                y = (canvasHeight - textSize.height) / 1f
            )
            // 4. Draw the text
            drawText(
                textLayoutResult = textLayoutResult,
                topLeft = topLeft
            )
            GameView(this, canvasWidth.toInt(), canvasHeight.toInt(), TODO())
            DrawAvailableSquare(this, 0, 0)
        }
    }