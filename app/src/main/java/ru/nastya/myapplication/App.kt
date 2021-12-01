package ru.nastya.myapplication

import android.app.Application
import ru.nastya.myapplication.ui.main.MainRouter

class App : Application(){
    lateinit var mainRouter: MainRouter
    override fun onCreate() {
        super.onCreate()
    }
}