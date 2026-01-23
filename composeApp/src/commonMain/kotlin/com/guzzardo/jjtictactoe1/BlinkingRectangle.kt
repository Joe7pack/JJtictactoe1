package com.guzzardo.jjtictactoe1

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun BlinkingRectangle(
    modifier: Modifier = Modifier,
    color: Color = Color.Red,
    durationMillis: Long = 1000 // Total blink cycle (on+off)
) {
    // State to control visibility/alpha
    var isVisible by remember { mutableStateOf(true) }

    // Effect to handle the blinking animation
    LaunchedEffect(Unit) {
        while (true) {
            delay(durationMillis / 2) // Stay on for half the cycle
            isVisible = false
            delay(durationMillis / 2) // Stay off for half the cycle
            isVisible = true
        }
    }

    // The rectangle composable
    Box(
        modifier = modifier
            .size(100.dp) // Example size
            .alpha(if (isVisible) 1f else 0f) // Control transparency
            .background(color)
    )
}

// Usage Example in a shared screen
@Composable
fun BlinkingScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BlinkingRectangle(
            modifier = Modifier.padding(16.dp),
            color = Color.Blue,
            durationMillis = 700
        )
        Text("This rectangle blinks!", color = Color.Gray)
    }
}
