package com.example.onlineshop.fragmentslogin

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.onlineshop.MainActivity2
import com.example.onlineshop.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.register_fragment.*
import module.UserInfo

class Fragment2 : Fragment(R.layout.register_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = view.findViewById<EditText>(R.id.usernameReg)
        val firstname = view.findViewById<EditText>(R.id.nameReg)
        val sueName = view.findViewById<EditText>(R.id.surnameReg)
        val age = view.findViewById<EditText>(R.id.ageNameReg)
        val postcode = view.findViewById<EditText>(R.id.postalReg)
        val editText = view.findViewById<TextView>(R.id.edittext3)
        val editText2 = view.findViewById<TextView>(R.id.edittext4)
        val editText3 = view.findViewById<TextView>(R.id.editText5)
        val button = view.findViewById<TextView>(R.id.button3)
        val back = view.findViewById<ImageView>(R.id.back)

        button.setOnClickListener {
            val usernm = username.text.toString()
            val name = firstname.text.toString()
            val surname = sueName.text.toString()
            val aGe = age.text.toString()
            val postcod = postcode.text.toString()
            val email = editText.text.toString()
            val pass = editText2.text.toString()
            val pass2 = editText3.text.toString()

            if (usernm.isEmpty()){
                username.error = "enter username"
                return@setOnClickListener
            }
            if (name.isEmpty()){
                firstname.error = "enter name"
                return@setOnClickListener
            }
            if (surname.isEmpty()){
                sueName.error = "enter surname"
                return@setOnClickListener
            }
            if (aGe.isEmpty()){
                age.error = "enter age"
                return@setOnClickListener
            }
            val asaki = aGe.toInt()
            if (asaki < 18){
                age.error = "should be 18 or more"
                return@setOnClickListener
            }
            if (postcod.isEmpty()){
                postcode.error = "enter postal code"
                return@setOnClickListener
            }
            if (postcod.length <4){
                postcode.error = "post code should contain 4 character"
                return@setOnClickListener
            }
            if (email.isEmpty()) {
                editText.error = "enter e-mail"
                return@setOnClickListener
            }

            if (pass.isEmpty()){
                edittext3.error = "enter password"
                return@setOnClickListener
            }
            if (pass.length < 8){
                editText3.error = "password should be Minimum 8 character"
            }
            if (pass2.length < 8){
                editText3.error = "password should be Minimum 8 character"
            }
            if (pass2.isEmpty()){
                edittext4.error = "enter password"
                return@setOnClickListener
            }
            if (pass == pass2) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, pass)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val user = UserInfo(usernm,name,surname,aGe,postcod,FirebaseAuth.getInstance().currentUser?.uid!!)
                            FirebaseDatabase.getInstance().getReference("users")
                                .child(FirebaseAuth.getInstance().currentUser?.uid!!).setValue(user)
                                .addOnCompleteListener {
                                    task ->
                                    if (task.isSuccessful){
                                        Toast.makeText(activity, "User has been succesfully registered!", Toast.LENGTH_SHORT).show()
                                    }else{
                                        Toast.makeText(activity, "Something went wrong!\nTry again", Toast.LENGTH_SHORT).show()
                                    }
                                }
                            startactivit()
                        }else{
                            Toast.makeText(activity, "Erroe occured", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(activity, "password doesn't match", Toast.LENGTH_SHORT).show()

            }
        }
        back.setOnClickListener{
            tofrag1()
        }


    }
    private fun tofrag1(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmenti_ukve_mzad, Fragment1())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }
    private fun startactivit(){
        val intent = Intent(activity, MainActivity2::class.java)
        startActivity(intent)
        activity?.finish()
    }


}