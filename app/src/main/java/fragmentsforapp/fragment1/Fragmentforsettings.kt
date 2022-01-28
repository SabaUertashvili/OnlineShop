package fragmentsforapp.fragment1

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.onlineshop.R
import com.example.onlineshop.fragmentslogin.Fragment1
import com.google.firebase.auth.FirebaseAuth

class Fragmentforsettings : Fragment(R.layout.settings_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editprofile = view.findViewById<TextView>(R.id.editProfile)
        val changepassword = view.findViewById<TextView>(R.id.ChangePass)
        val logout = view.findViewById<TextView>(R.id.LOgOut)
        editprofile.setOnClickListener {
            editptofile()
        }
        changepassword.setOnClickListener {
            changepass()
        }
        logout.setOnClickListener {
            AlertDialog.Builder(activity)
                .setTitle("Log Out")
                .setMessage("Do you really want to log out?")
                .setNegativeButton("no"){dialog,_ ->
                    dialog.dismiss()
                }
                .setPositiveButton("yes"){dialog, _ ->
                    FirebaseAuth.getInstance().signOut()

                    tofrag1()

                }.show()
        }


    }
    private fun editptofile (){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.Fragments_Already, Fragmenteditprofilw())
        transaction?.disallowAddToBackStack()
        transaction?.commit()

    }
    private fun changepass (){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.Fragments_Already, ChangePassword())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }
    private fun tofrag1() {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.Fragments_Already, Fragment1())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
        activity?.finish()
    }
}