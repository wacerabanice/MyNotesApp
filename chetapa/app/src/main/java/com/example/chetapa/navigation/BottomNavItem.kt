package com.example.chetapa.navigation

import com.example.chetapa.R

sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){

        object Home : BottomNavItem("Home", R.drawable.ic_home,"home")
        object Profile: BottomNavItem("Profile", R.drawable.ic_profile,"profile")
        object Credit: BottomNavItem("Credit", R.drawable.ic_credit,"credit")

    }
