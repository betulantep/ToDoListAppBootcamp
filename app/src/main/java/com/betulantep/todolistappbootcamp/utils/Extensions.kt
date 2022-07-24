package com.betulantep.todolistappbootcamp.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.actionFragment(view: View,id: Int){
    findNavController(view).navigate(id)
}

fun Navigation.actionFragment(view: View,directions: NavDirections){
    findNavController(view).navigate(directions)
}