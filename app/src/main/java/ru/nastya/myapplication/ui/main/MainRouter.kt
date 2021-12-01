package ru.nastya.myapplication.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ru.nastya.myapplication.R


class MainRouter (private val fragmentManager: FragmentManager) {

    fun back() {
        fragmentManager.popBackStack()
    }

    fun updateMainFragment(fragment: Fragment){
        fragmentManager.beginTransaction()
            .replace(R.id.full_content, fragment)
            .addToBackStack(null)
            .commit()
    }
}