package com.example.onlineshop.fragmentslogin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.google.firebase.auth.FirebaseAuth

class Fragment3 : Fragment(R.layout.passreset_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edit = view.findViewById<EditText>(R.id.editText2)
        val brn1 = view.findViewById<Button>(R.id.button2)
        val back = view.findViewById<TextView>(R.id.backPassReset)
        
        brn1.setOnClickListener{
            val email = edit.text.toString()
            if (email.isEmpty()){
                Toast.makeText(activity, "enter E-mail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener { 
                task->
                if (task.isSuccessful){
                    Toast.makeText(activity, "Check E-mail", Toast.LENGTH_SHORT).show()
                    tofrag1()
                }else{
                    Toast.makeText(activity, "error occured", Toast.LENGTH_SHORT).show()
                }
            }
        }
        back.setOnClickListener {
            tofrag1()
        }
    }
    private fun tofrag1(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmenti_ukve_mzad, Fragment1())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }

}