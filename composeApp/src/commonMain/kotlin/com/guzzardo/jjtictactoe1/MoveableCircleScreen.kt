package com.guzzardo.jjtictactoe1

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MoveableCircleScreen(viewModel: MyViewModel = viewModel()) {
    //val position = viewModel.circlePosition

    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    // Update the state in the ViewModel
                    //viewModel.updatePosition(position + dragAmount)
                }
            }
    ) {
        // Draw the circle at the current state-driven position
        //DrawACircle(this)
        drawCircle(
            color = Color.Blue,
            radius = 100f,
            //center = position
        )
    }
}
