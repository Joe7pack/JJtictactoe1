package com.guzzardo.jjtictactoe1

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.IntRect
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.jetbrains.compose.resources.StringArrayResource
import kotlinx.coroutines.flow.update
import jjtictactoe1.composeapp.generated.resources.Res // Generated resource class
import jjtictactoe1.composeapp.generated.resources.planets_array
import jjtictactoe1.composeapp.generated.resources.prize_token
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.imageResource
import kotlin.time.Clock

sealed interface DrawingAction {
    data object OnNewPathStart: DrawingAction  //an object is a singleton or a static member
    data class OnDraw(val offset: Offset): DrawingAction //a class is designed to hold data
    data object OnPathEnd: DrawingAction
    data class OnSelectColor(val color: Color): DrawingAction
    data object OnClearCanvasClick: DrawingAction
    }

sealed interface GameAction {
    data class OnStartGame(val canvasSize: Offset): GameAction
    data class OnNewGame(val gameSize: Offset): GameAction
}

data class DrawingState(
    val colorPlayer1: Color = Color.Red,
    val colorPlayer2: Color = Color.Blue,
    val currentPath: PathData? = null,
    val paths: List<PathData> = emptyList(),
    val blinkRect: IntRect = IntRect.Zero,
    val Player1: Boolean = false,
    val Player2: Boolean = false,
    val prizeImageBitmap: DrawableResource = Res.drawable.prize_token,
    val prizeLocation: Int = -1,
    var canvasSize: Offset = Offset(0F, 0F),
    var gameSize: Offset = Offset(0F, 0F),
    var rotationDegrees: Float = 0F
)

val allColors = listOf(
    Color.Black,
    Color.Red,
    Color.Blue,
    Color.Green,
    Color.Yellow,
    Color.Magenta,
    Color.Cyan,
)

data class PathData(
    val id: String,
    val color: Color,
    val path: List<Offset>
)

open class MyViewModel : ViewModel() {
    // Initial state points to a specific generated StringArrayResource
    private val _currentArray = MutableStateFlow<StringArrayResource>(Res.array.planets_array)
    val currentArray = _currentArray.asStateFlow() //read only StateFlow
    private val _currentDrawingState = MutableStateFlow(DrawingState())
    val currentDrawingState = _currentDrawingState.asStateFlow()
    private val _state = MutableStateFlow(DrawingState())
    val state = _state.asStateFlow()
    private val _gameSize = MutableStateFlow(Offset(200f, 200f))
    val gameSize = _gameSize.asStateFlow()
    private val _circleColor = MutableStateFlow(Color.Blue)
    val circleColor = _circleColor.asStateFlow()
    private val _pivotPoint = MutableStateFlow(Offset(200f, 200f))
    val pivotPoint = _pivotPoint.asStateFlow()
    private val _rotationDegrees = MutableStateFlow(0F)
    val rotationDegrees = _rotationDegrees.asStateFlow()

    val selectedColor = _state.value.colorPlayer1 //Color

    //val circleColor: State<Color> = _circleColor
    //val circleColor = _circleColor.asStateFlow()
        //private set

        //private set

    // Update position based on Canvas size
    fun updateGameSize(newOffset: Offset) {
        _gameSize.value = newOffset
    }

    fun updatePivotPoint(newOffset: Offset) {
        _pivotPoint.value = newOffset
    }

    fun updateRotationDegrees(newRotation: Float) {
        _rotationDegrees.value = newRotation
    }

    fun getRotationDegrees(): Float {
        return _rotationDegrees.value
    }

    fun changeColor() {
        _circleColor.value = Color.Red
    }

    fun onAction(action: DrawingAction) {
        when(action) {
            DrawingAction.OnClearCanvasClick -> onClearCanvasClick()
            is DrawingAction.OnDraw -> onDraw(action.offset)
            DrawingAction.OnNewPathStart -> onNewPathStart()
            DrawingAction.OnPathEnd -> onPathEnd()
            is DrawingAction.OnSelectColor -> onSelectColor(action.color)

        }
    }
    fun onAction(action: GameAction) {
        when(action) {
            is GameAction.OnStartGame -> onStartGame(action.canvasSize)
            is GameAction.OnNewGame -> onNewGame(gameSize = action.gameSize)
        }
    }

    private fun onDraw(offset: Offset) {
        val currentPathData = state.value.currentPath ?: return
        _state.update { it.copy(
            currentPath = currentPathData.copy(
                path = currentPathData.path + offset
            )
        ) }
    }

    /* private */ fun onSelectColor(color: Color) {
        _state.update { it.copy(
            colorPlayer1 = color
        ) }
    }

    private fun onPathEnd() {
        val currentPathData = state.value.currentPath ?: return
        _state.update { it.copy(
            currentPath = null,
            paths = it.paths + currentPathData
        ) }
    }

    private fun onNewPathStart() {
        _state.update { it.copy(
            currentPath = PathData(
                id = "JoeWasHere", //Clock.System.currentTimeMillis().toString(),
                color = it.colorPlayer1,
                path = emptyList()
            )
        )
        }
    }

    private fun onClearCanvasClick() {
        _state.update { it.copy(
            currentPath = null,
            paths = emptyList()
        ) }
    }

    private fun onStartGame(canvasSize: Offset) {
        _state.update { it.copy(
            canvasSize = canvasSize
        )
        }
    }

    /* private */ fun onNewGame(gameSize: Offset) {
        _state.update { it.copy(
            gameSize = gameSize
        )
        }
    }
}

// ViewModelFactory that retrieves the data repository for your app.
// per Android official website - If the ViewModel takes no dependencies or just the SavedStateHandle type as a dependency,
// you don't need to provide a factory for the framework to instantiate instances of that ViewModel type.