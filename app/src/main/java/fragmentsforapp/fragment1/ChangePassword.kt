package fragmentsforapp.fragment1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.google.firebase.auth.FirebaseAuth

class ChangePassword : Fragment(R.layout.passchange_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editcurpass = view.findViewById<EditText>(R.id.editText)
        val editnewpass = view.findViewById<EditText>(R.id.editText4)
        val editnew2pass = view.findViewById<EditText>(R.id.CurPass)
        val batton = view.findViewById<Button>(R.id.change)
        
        batton.setOnClickListener { 
            val current = editcurpass.text.toString()
            val new = editnewpass.text.toString()
            val new2 = editnew2pass.text.toString()

            if (current.isEmpty()||new.isEmpty()||new2.isEmpty()){
                Toast.makeText(activity, "the field is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (new == new2) {
                FirebaseAuth.getInstance().currentUser?.updatePassword(new)
                    ?.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(activity, "Password changed", Toast.LENGTH_SHORT).show()
                            tosettings()
                        } else {
                            Toast.makeText(
                                activity,
                                "Current password is incorrect",
                                Toast.LENGTH_SHORT
                            ).show()
                            return@addOnCompleteListener


                        }
                    }
            }
            else{
                Toast.makeText(activity, "new passwords doesn't match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            
        }
    }
    private fun tosettings(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmenti_ukve_mzad, Fragment13())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }

    
}