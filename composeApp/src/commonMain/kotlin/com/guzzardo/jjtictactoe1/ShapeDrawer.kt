package com.guzzardo.jjtictactoe1

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

class ShapeDrawer(val color: Color) {
    fun drawHighlight(drawScope: DrawScope) {
        // Shared logic for drawing a custom shape
        drawScope.drawCircle(color = color, radius = 50f)
    }
}