package com.example.composecomponent.data.model

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")

    object Detail : Screen("detail_screen?id={id}&name={name}") {

        fun passId(id: Int = 1): String {
            return "detail_screen?id=$id"
            // return this.route.replace("{id}", id.toString())
        }

        fun passNameAndId(id: Int, name: String): String {
            // return "profile_screen/$id"
            return "detail_screen?id=$id&name=$name"
        }


    }

    object Profile : Screen("profile_screen/{id}/{name}") {
//        fun passId(id : Int): String{
//           // return "profile_screen/$id"
//            return this.route.replace("{id}", id.toString())
//        }

        fun passNameAndId(id: Int, name: String): String {
            // return "profile_screen/$id"
            return this.route.replace("{id}", id.toString()).replace("{name}", name)
        }

    }
}