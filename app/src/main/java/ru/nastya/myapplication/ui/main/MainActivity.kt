package ru.nastya.myapplication.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.nastya.myapplication.App
import ru.nastya.myapplication.R
import ru.nastya.myapplication.databinding.ActivityMainBinding
import ru.nastya.myapplication.ui.cake.cakeList.CakeListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (applicationContext as App).mainRouter = MainRouter(supportFragmentManager)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.full_content,CakeListFragment())
            .commit()
    }

}