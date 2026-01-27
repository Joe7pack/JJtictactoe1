package com.guzzardo.jjtictactoe1

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.lifecycle.viewmodel.compose.viewModel
import jjtictactoe1.composeapp.generated.resources.Res
import jjtictactoe1.composeapp.generated.resources.prize_token
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.imageResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun InitializeGame2(drawScope: DrawScope) {
    //drawScope.drawCircle(color = Color.Green, 1F, Offset(1F, 1F))
    //val mBmpPrize: DrawableResource =  Res.drawable.prize_token
    //val imageBitmap = imageResource(Res.drawable.prize_token)
    //drawScope.drawImage(imageBitmap)
    // Observe the resource reference from ViewModel
    //val arrayResource by viewModel.currentArray.collectAsState()
    //val items: List<String> = stringArrayResource(arrayResource)
    //val gameDrawingState by viewModel.currentDrawingState.collectAsState()
    //val tokenColor1 = gameDrawingState.colorPlayer1
    //val tokenColor2 = gameDrawingState.colorPlayer2
    //mBlinkRect = gameDrawingState.blinkRect
    //val mTokenColor1 = gameDrawingState.colorPlayer1
    //mTokenColor2 = gameDrawingState.colorPlayer2
    drawScope.drawCircle(color =Color.Green, 1F, Offset(1F, 1F))
}