package com.guzzardo.jjtictactoe1

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach

@Composable
fun GameCanvas(
    onAction: (DrawingAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .drawBehind(onDraw = { drawAnotherGameBoard() })
    ) { drawLine(
        start = Offset(x = 0f, y = 10f),
        end = Offset(size.width, y = size.height),
        color = Color.Red,
        strokeWidth = 5.dp.toPx()
    )
        drawLine(
            start = Offset(0f, y = size.height),
            end = Offset(size.width, y = 0f),
            color = Color.Blue,
            strokeWidth = 20.dp.toPx()
        )}
}

@Composable
fun InitializeGame9() {
}