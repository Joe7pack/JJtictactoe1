package com.guzzardo.jjtictactoe1

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Canvas
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun GameCanvas(
    model: MyViewModel,
    size: Offset,
    onAction: (DrawingAction) -> Unit,
    modifier: Modifier = Modifier
) {
    val pivotPoint = model.pivotPoint
    val rotationDegrees = model.rotationDegrees

    //var circleCenter by remember { mutableStateOf(Offset(width.value, height.value)) }
    BoxWithConstraints {
        //val width = this.maxWidth
        //val height = this.maxHeight
        val newOffset = size //Offset(width.value, height.value)
        model.updateGameSize(newOffset)
        model.onNewGame(newOffset)
        //val pivotPoint = Offset(width.value/2, height.value/2)
        //val pivotPoint2 by remember { mutableStateOf(pivotPoint) }
        var rotationDegrees by remember { mutableStateOf(rotationDegrees) }
        if (newOffset.x < newOffset.y) {
            model.updateRotationDegrees(90F)
            //model.updateRotationDegrees(rotationDegrees)
        }
        Text(text = "Window dimensions: Width $newOffset.x, Height $newOffset.y)")
    }
    Canvas(
        modifier = modifier
        //.drawBehind(onDraw = { drawAnotherGameBoard() })
    ) {
        // Calculate the center of the rectangle for the pivot point
        val size = model.gameSize.value
        //val rotationDegrees = model.rotationDegrees //.rotationDegrees.value
        //val pivot = Offset(size.x/2, size.y/2)
        //rotate(model.rotationDegrees.value, pivot) {
        //model.updateRotationDegrees(rotationDegrees)
            drawLine(
                start = Offset(x = 0f, y = 0f),
                end = Offset(size.x, y = size.y),
                color = Color.Red,
                strokeWidth = 2.dp.toPx()
            )
            drawLine(
                start = Offset(0f, y = size.y),
                end = Offset(size.x, y = 0f),
                color = Color.Blue,
                strokeWidth = 2.dp.toPx()
            )
            drawLine(
                start = Offset(0f, y = size.y/2),
                end = Offset(size.x, y = size.y/2),
                color = Color.Green,
                strokeWidth = 2.dp.toPx()
            )
            drawLine(
                start = Offset(0f, y = size.y),
                end = Offset(size.x, y = size.y),
                color = Color.Yellow,
                strokeWidth = 2.dp.toPx()
            )
            drawLine(
                start = Offset(size.x/2, y = 0f),
                end = Offset(size.x/2, y = size.y),
                color = Color.Black,
                strokeWidth = 2.dp.toPx()

            )
        //} //
    }
    //}

    @Composable
    fun InitializeGame9() {
    }
}