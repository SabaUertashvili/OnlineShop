package com.example.onlineshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

import com.google.android.material.bottomnavigation.BottomNavigationView
import fragmentsforapp.fragment1.Fragment11

import fragmentsforapp.fragment1.Fragment13


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.Navigation)
        val controller = findNavController(R.id.Fragments_Already)

        bottomNavigationView.setupWithNavController(controller)

        supportFragmentManager.beginTransaction().replace(R.id.Fragments_Already,Fragment11()).commit()

    }
}