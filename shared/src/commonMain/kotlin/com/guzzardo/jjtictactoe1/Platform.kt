package com.guzzardo.jjtictactoe1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform