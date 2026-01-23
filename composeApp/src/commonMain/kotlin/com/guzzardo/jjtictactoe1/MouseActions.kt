package com.guzzardo.jjtictactoe1

import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.positionChange
import androidx.compose.ui.input.pointer.positionChanged

@Composable
fun MultiplatformMotionEventEquivalent() {
    var touchPosition by remember { mutableStateOf<Offset?>(null) }
    Canvas(modifier = Modifier
            .pointerInput(Unit) {
                // Manually process pointer events
                awaitPointerEventScope {
                    while (true) {
                        val event = awaitPointerEvent()
                        val changes = event.changes
                        // Handle different actions
                        if (changes.any { it.pressed }) {
                            // Equivalent to ACTION_DOWN or new pointer down
                            touchPosition = changes.first().position
                        } else if (changes.any { it.positionChange().getDistance() != 0f  }) {
                            // Equivalent to ACTION_MOVE
                            touchPosition = changes.first().position
                        } else if (changes.all { !it.pressed }) {
                            // Equivalent to ACTION_UP or all pointers up
                            touchPosition = null
                        }
                        // Mark as consumed if necessary to prevent parent views from handling
                        changes.forEach { it.consume() }
                    }
                }
            }
    ) {
        // Drawing logic using touchPosition
    }
}
