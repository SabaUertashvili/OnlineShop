package com.example.onlineshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.onlineshop.fragmentslogin.Fragment1
import com.example.onlineshop.fragmentslogin.Fragment2
import com.example.onlineshop.fragmentslogin.Fragment3
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findNavController(R.id.fragmenti_ukve_mzad)


    }




}