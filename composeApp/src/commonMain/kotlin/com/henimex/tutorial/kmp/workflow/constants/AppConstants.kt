package com.henimex.tutorial.kmp.workflow.constants

object AppConstants {
    object MainScreen {
        const val NAME = "main-screen"
        const val PARAM_NAME = "null"
        const val ROUTE_LINK = "$NAME/{$PARAM_NAME}"
    }

    object DetailScreen {
        const val NAME = "detail-screen"
        const val PARAM_NAME = "null"
        const val ROUTE_LINK = "$NAME/{$PARAM_NAME}"
    }

    object DetailedScreen {
        const val NAME = "detailed-screen"
        const val PARAM_NAME = "data"
        const val ROUTE_LINK = "$NAME/{$PARAM_NAME}"
    }

    object CollectionScreen {
        const val NAME = "item-collection-screen"
        const val PARAM_NAME = "item"
        const val ROUTE_LINK = "$NAME/{$PARAM_NAME}"
    }
}