package com.guzzardo.jjtictactoe1

import androidx.compose.foundation.Canvas
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.drawscope.DrawScope
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
                    println("Button clicked for Joes item: $item")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) { Text(item)
            }
        }
    }
}
fun DrawScope.drawNewGameBoard( ) {
    drawLine(
        start = Offset(x = 0f, y = 0f),
        end = Offset(size.width, y = size.height),
        color = Color.Cyan,
        strokeWidth = 20.dp.toPx()
    )
}

fun DrawScope.drawAnotherGameBoard( ) {
    drawLine(
        start = Offset(x = 10f, y = 10f),
        end = Offset(size.width, y = size.height),
        color = Color.Red,
        strokeWidth = 5.dp.toPx()
    )
}


@Composable
fun DrawScope.InitializeJJGame(viewModel: MyViewModel  = viewModel()) {
//@Composable
//fun DrawScope.InitializeJJGame() {
    //val myViewModel = MyViewModel

    // Observe the resource reference from ViewModel
    val someVal = Offset(10F, 10F)
    val arrayResource by viewModel.currentArray.collectAsState()

    /*

    val items: List<String> = stringArrayResource(arrayResource)

    val gameDrawingState by viewModel.currentDrawingState.collectAsState()
    val tokenColor1 = gameDrawingState.colorPlayer1
    val tokenColor2 = gameDrawingState.colorPlayer2
    var mBlinkRect = gameDrawingState.blinkRect
    var mTokenColor1 = tokenColor1
    var mTokenColor2 = tokenColor2
    */

    //DrawingState.PLAYER1 = false
    /*

    mBmpPrize = createBitmapFromResource(Res.drawable.prize_token)
    mBmpCrossPlayer1 = createBitmapFromResource(Res.drawable.lib_crossred)
    SetTokenColor(mBmpCrossPlayer1!!, mTokenColor1)
    mBmpCrossPlayer2 = createBitmapFromResource(Res.drawable.lib_crossblue)
    SetTokenColor(mBmpCrossPlayer2!!, mTokenColor2)
    mBmpCrossCenter = createBitmapFromResource(Res.drawable.lib_crossgreen)
    mBmpCirclePlayer1 = createBitmapFromResource(Res.drawable.lib_circlered)
    SetTokenColor(mBmpCirclePlayer1!!, mTokenColor1)
    mBmpCirclePlayer2 = createBitmapFromResource(Res.drawable.lib_circleblue)
    SetTokenColor(mBmpCirclePlayer2!!, mTokenColor2)
    mBmpCircleCenter = createBitmapFromResource(Res.drawable.lib_circlegreen)
    mBmpCircleCrossPlayer1 = createBitmapFromResource(Res.drawable.lib_circlecrossred)
    SetTokenColor(mBmpCircleCrossPlayer1!!, mTokenColor1)
    mBmpCircleCrossPlayer2 = createBitmapFromResource(Res.drawable.lib_circlecrossblue)
    SetTokenColor(mBmpCircleCrossPlayer2!!, mTokenColor2)
    mBmpCircleCrossCenter = createBitmapFromResource(Res.drawable.lib_circlecrossgreen)
    mBmpAvailableMove = createBitmapFromResource(Res.drawable.allowed_move)
    mBmpTakenMove = createBitmapFromResource(Res.drawable.taken_move)
    //mSrcRect[0, 0, mBmpCrossPlayer1!!.width - 1] = mBmpCrossPlayer1!!.height - 1
    //mTakenRect[0, 0, mBmpAvailableMove.width - 1] = mBmpAvailableMove.height - 1
    mLinePaint.color = Color.Blue
    mLinePaint.strokeWidth = GRIDLINEWIDTH.toFloat()
    mLinePaint.style = PaintingStyle.Stroke
    //mWinPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    mWinPaint.color = Color.Yellow
    mWinPaint.strokeWidth = 5f // was 10
    mWinPaint.style = PaintingStyle.Stroke
    mTextPaint.color = Color.Green
    mTextPaint.strokeWidth = 1f
    mTextPaint.style = PaintingStyle.Stroke
    //InitializeGameValues()
    */
}

@Preview
@Composable
fun MultiplatformView2() {
    val drawer = remember { ShapeDrawer(Color.Blue) }

    Canvas(modifier = Modifier.fillMaxSize()) {
        // 'this' refers to DrawScope here
        drawer.drawHighlight(this)

        // You can also call members directly if the class is an extension
        // or just use its properties to drive standard draw commands
        drawRect(color = drawer.color, size = size / 2f)
    }
}