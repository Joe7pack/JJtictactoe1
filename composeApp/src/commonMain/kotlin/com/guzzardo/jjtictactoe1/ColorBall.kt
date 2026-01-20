package com.guzzardo.jjtictactoe1

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.geometry.Rect
import com.guzzardo.jjtictactoe1.GameView.ScreenOrientation

class ColorBall(bitmap: ImageBitmap, pointLandscape: Point, pointPortrait: Point, displayMode: Int, type: Int, color: Int) {
    lateinit var bitmap: ImageBitmap // the image of the ball
    //private val bitmapWidth: Int
    private var coordX: Float = 0F // the current x coordinate at the canvas = 0
    private var coordY: Float = 0F // the current y coordinate at the canvas = 0
    private val startingLandscapeCoordX: Float // the starting x coordinate at the canvas
    private val startingLandscapeCoordY: Float // the starting y coordinate at the canvas
    private val startingPortraitCoordX: Float // the starting x coordinate at the canvas
    private val startingPortraitCoordY: Float // the starting y coordinate at the canvas
    private val mDisplayMode: Int //portrait or landscape
    val iD: Int // gives every ball its own id
    var type: Int // circle, cross or circleCross token
    var isDisabled =
        false //indicates ball can no longer be moved (finalized placement on board) = false

    @Composable
    fun UpdateBall(type: Int, bitmap: ImageBitmap) {
        this.type = type
        this.bitmap = bitmap
        resetPosition(mDisplayMode)
        isDisabled = false
    }

    fun getCoordX(): Float {
        return coordX
    }

    fun getCoordY(): Float {
        return coordY
    }

    fun setCoordX(newValue: Float) {
        coordX = newValue
    }

    fun setCoordY(newValue: Float) {
        coordY = newValue
    }

    fun getMaxBalls(): Int {
        return MAXBALLS
    }

    fun resetPosition(displayMode: Int) {
        if (displayMode == ScreenOrientation.LANDSCAPE) {
            coordX = startingLandscapeCoordX
            coordY = startingLandscapeCoordY
        } else {
            coordX = startingPortraitCoordX
            coordY = startingPortraitCoordY
        }
    }

    val rect: Rect
        get() = Rect(coordX, coordY, 0F, 0F)

    companion object {
        var count = 0
        const val MAXBALLS = 8
        const val CIRCLE = 0
        const val CROSS = 1
        const val CIRCLECROSS = 2
    }

     init {
        //setTokenColor(bitmap, color)
        iD = count
        count++
        if (count > MAXBALLS - 1)
            count = 0
        if (displayMode == ScreenOrientation.LANDSCAPE) {
            coordX = pointLandscape.x.toFloat()
            coordY = pointLandscape.y.toFloat()
        } else {
            coordX = pointPortrait.x.toFloat()
            coordY = pointPortrait.y.toFloat()
        }
        startingLandscapeCoordX = pointLandscape.x.toFloat()
        startingLandscapeCoordY = pointLandscape.y.toFloat()
        startingPortraitCoordX = pointPortrait.x.toFloat()
        startingPortraitCoordY = pointPortrait.y.toFloat()
        this.type = type
        mDisplayMode = displayMode
    }
}