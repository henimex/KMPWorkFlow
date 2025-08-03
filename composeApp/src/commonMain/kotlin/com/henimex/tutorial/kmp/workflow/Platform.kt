package com.henimex.tutorial.kmp.workflow

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform