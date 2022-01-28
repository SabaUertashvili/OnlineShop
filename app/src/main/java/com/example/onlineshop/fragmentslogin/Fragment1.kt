package com.example.onlineshop.fragmentslogin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.onlineshop.MainActivity2
import com.example.onlineshop.R
import com.google.firebase.auth.FirebaseAuth

class Fragment1 : Fragment(R.layout.login_fragment) {
    private lateinit var edittext: EditText
    private lateinit var edittext2 : EditText
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (FirebaseAuth.getInstance().currentUser != null){
            startactivit()
        }
        
        edittext = view.findViewById(R.id.editTextTextEmailAddress)
        edittext2 = view.findViewById(R.id.editTextTextPassword)
        val button = view.findViewById<Button>(R.id.button)
        val textView2 = view.findViewById<TextView>(R.id.textView2)
        val textView3 = view.findViewById<TextView>(R.id.textView3)

        button.setOnClickListener{
            val email = edittext.text.toString()
            val password = edittext2.text.toString()
            if (email.isEmpty()){
                Toast.makeText(activity, "The field is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                edittext2.error = "Enter password"
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener{ task ->
                if (task.isSuccessful){
                    startactivit()

                }else{
                    Toast.makeText(activity, "Incorrect password", Toast.LENGTH_SHORT).show()
                    return@addOnCompleteListener
                }
            }

        }

        textView2.setOnClickListener{
            tofrag2()
        }
        textView3.setOnClickListener {
            tofrag()
        }
    }
    private fun tofrag(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmenti_ukve_mzad, Fragment2())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }
    private fun tofrag2(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmenti_ukve_mzad, Fragment3())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }
    private fun startactivit(){
        val intent = Intent(activity, MainActivity2::class.java)
        startActivity(intent)
        activity?.finish()
    }


}