package com.guzzardo.jjtictactoe1

import androidx.compose.ui.graphics.ImageBitmap
import com.guzzardo.jjtictactoe1.GameView.BoardSpaceValues

object GameCompanion { // originally GameView.companion object
    val FPS_MS = (1000 / 2).toLong()
    //constants related to gameBoard drawing:
    val MARGIN = 5
    val GRIDLINEWIDTH = 4
    //TODO - calculate these 3 values in onMeasure
    var TOKENSIZE = 0 // bitmap pixel size of X or O card on board
    var mTokenRadius = 40 // used to specify the touch points when moved by the player's finger
    val PORTRAITOFFSETX = 5 // X offset to board grid in portrait mode
    val PORTRAITOFFSETY = 5
    val PORTRAITWIDTHHEIGHT = 300 // portrait width and height of view square
    var BoardLowerLimit = 0
    var mDisplayMode = 0 // portrait or landscape
    val portraitComputerLiteralOffset = 245
    val portraitHumanTokenSelectedOffsetX = 20
    var landscapeRightMoveXLimitPlayer1 = 0
    var landscapeLeftMoveXLimitPlayer2 = 0
    var landscapeRightMoveXLimitPlayer2 = 0
    var landscapeLeftMoveXLimitPlayer1 = 0
    val landscapeHumanTokenSelectedOffsetX = 25
    val portraitIncrementXPlayer1 = 50
    val portraitIncrementYPlayer1 = 0
    val portraitStartingXPlayer1 = 50
    val portraitStartingYPlayer1 = 260
    val portraitIncrementXPlayer2 = 0
    val portraitIncrementYPlayer2 = 50
    val portraitStartingXPlayer2 = 260
    val portraitStartingYPlayer2 = 60
    val landscapeIncrementXPlayer1 = 0
    var landscapeIncrementYPlayer = 0
    val landscapeStartingXPlayer1 = 50
    val landscapeStartingYPlayer1 = 25
    val landscapeIncrementXPlayer2 = 0
    var landscapeStartingXPlayer2 = 0
    val landscapeStartingYPlayer2 = 25
    val MSG_BLINK = 1
    val MSG_BLINK_TOKEN = 2
    val MSG_BLINK_SQUARE = 3
    val SPACENOTAVAILABLE = false
    var INITIALIZATIONCOMPLETED = false
    val NUMBEROFTOKENS = 9
    var mTokenSize = 0
    var computerMove: Int = 0 //temporary value to assign token to computer move
    var mPlayer1TokenChoice: Int = 0
    var mPlayer2TokenChoice: Int = 0
    val mStartingPlayerTokenPositions = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(0, 0), intArrayOf(0, 0))
    val startingGameTokenCard = intArrayOf(
        BoardSpaceValues.CIRCLE,
        BoardSpaceValues.CROSS,
        BoardSpaceValues.CIRCLE,
        BoardSpaceValues.CROSS,
        BoardSpaceValues.CIRCLE,
        BoardSpaceValues.CROSS,
        BoardSpaceValues.CIRCLE,
        BoardSpaceValues.CROSS,
        BoardSpaceValues.CIRCLECROSS
    )
    var mGameTokenCard = intArrayOf(
        BoardSpaceValues.EMPTY,
        BoardSpaceValues.EMPTY,
        BoardSpaceValues.EMPTY,
        BoardSpaceValues.EMPTY,
        BoardSpaceValues.EMPTY,
        BoardSpaceValues.EMPTY,
        BoardSpaceValues.EMPTY,
        BoardSpaceValues.EMPTY,
        BoardSpaceValues.EMPTY
    )
    var mSxy = 0 // mSxy = TOKENSIZE + 2
    var mOffsetX = 0
    var mOffsetY = 0
    var prizeLocation = -1
    val mPrizeXBoardLocationArray = intArrayOf(0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4, 0, 1, 2, 3, 4)
    val mPrizeYBoardLocationArray = intArrayOf(0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4)
    var mPrizeXBoardLocation = 0
    var mPrizeYBoardLocation = 0
    var HUMAN_VS_HUMAN = false
    // var mClientThread: ClientThread? = null
    // var mGameActivity: GameActivity? = null
    var mPrevSelectedBall = 0 //save value for touch selection
    var mPrevSelectedCell = 0 //save value for touch selection
    // lateinit var resources: Resources
    fun writeToLog(filter: String, msg: String) {
        /*
        if ("true".equals(resources.getString(R.string.debug), ignoreCase = true)) {
            Log.d(filter, msg)
        }
         */
    }
    var mBmpCrossPlayer1: ImageBitmap? = null
    var mBmpCrossPlayer2: ImageBitmap? = null
    var mBmpCirclePlayer1: ImageBitmap? = null
    var mBmpCirclePlayer2: ImageBitmap? = null
    var mBmpCrossCenter: ImageBitmap? = null
    var mBmpCircleCenter: ImageBitmap? = null
    var mBmpCircleCrossCenter: ImageBitmap? = null
    var mBmpCircleCrossPlayer1: ImageBitmap? = null
    var mBmpCircleCrossPlayer2: ImageBitmap? = null
    lateinit var mBmpAvailableMove: ImageBitmap
    lateinit var mBmpTakenMove: ImageBitmap
    lateinit var mBmpPrize: ImageBitmap
}
