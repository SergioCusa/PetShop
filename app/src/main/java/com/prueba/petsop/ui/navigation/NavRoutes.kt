package com.prueba.petsop.ui.navigation

object NavRoutes {
    // Graphs
    const val ONBOARDING_GRAPH = "onboarding_graph"
    const val AUTH_GRAPH = "auth"
    const val APP_GRAPH = "app"

    // Screens
    const val ONBOARDING = "onboarding"
    const val LOGIN = "login"
    const val LOGIN_TEST = "login_test"
    const val REGISTER = "register"
    const val FORGOT = "forgot"
    const val PRODUCT_LIST = "product_list"

    // Nested
    const val APP_PRODUCT_LIST = "$APP_GRAPH/$PRODUCT_LIST"
}