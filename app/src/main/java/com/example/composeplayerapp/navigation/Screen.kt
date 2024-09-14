package com.example.navigation.navigation

const val DETAIL_ARG_ID = "id"
const val DETAIL_ARG_NAME = "name"

sealed class Screen(val route: String) {

    object Home   : Screen(route = "home_screen")

    //    object Detail : Screen(route = "detail_screen/{$DETAIL_ARG_ID}/{$DETAIL_ARG_NAME}") {

//        fun passId(id: Int): String {
//            return this.route.replace(
//                oldValue = "{$DETAIL_ARG_ID}",
//                newValue = id.toString()
//            )
//        }

//        fun passIdAndName(
//            id: Int,
//            name: String
//        ): String {
//            return "detail_screen/$id/$name"
//        }

    object Detail : Screen(route = "detail_screen?id={id}") {
        fun passId(id: Int = 0) : String {
            return "detail_screen/id=$id"
        }
    }
}
