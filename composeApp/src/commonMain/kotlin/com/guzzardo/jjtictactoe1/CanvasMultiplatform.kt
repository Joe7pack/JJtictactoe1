package com.guzzardo.jjtictactoe1

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.pointer.pointerInput
import androidx.lifecycle.viewmodel.compose.viewModel
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import jjtictactoe1.composeapp.generated.resources.Res
import jjtictactoe1.composeapp.generated.resources.compose_multiplatform
import jjtictactoe1.composeapp.generated.resources.favorites
import org.jetbrains.compose.resources.stringResource
import kotlin.coroutines.ContinuationInterceptor

@Composable
fun MultiplatformView() {
    //val drawer = remember { ShapeDrawer(Color.Blue) }
    val gamePlay = remember { GameView(20F, 20F, Color.Red, Color.Blue)}

    Canvas(modifier = Modifier.fillMaxSize()
                              //.pointerInput {  detectTapGestures(onTap = { /* handle tap */ } ) }
    ) {


        val myColor = gamePlay.selectedColor
        //drawHighlight(this)

        // You can also call members directly if the class is an extension
        // or just use its properties to drive standard draw commands
        //drawRect(color, topLeft = 0, size = size / 2f)
        drawRect(
            color = myColor, //Color.Magenta,
            topLeft = Offset(x = 0f, y = 0f), // Start coordinates (top-left is 0,0)
            size = Size(width = 50f, height = 100f) // Size of the rectangle
        )

    }
}


