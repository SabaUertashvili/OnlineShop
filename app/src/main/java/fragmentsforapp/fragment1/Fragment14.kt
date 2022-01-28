package fragmentsforapp.fragment1

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.onlineshop.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.mikhaellopez.circularimageview.CircularImageView
import kotlinx.android.synthetic.main.profile_fragment.view.*
import module.UserInfo
import java.util.*

class Fragment14 : Fragment(R.layout.profile_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val userName = view.findViewById<TextView>(R.id.username)
        val textname = view.findViewById<TextView>(R.id.nameE)
        val textsurname = view.findViewById<TextView>(R.id.lastNameText)
        val age = view.findViewById<TextView>(R.id.age)
        val postcode = view.findViewById<TextView>(R.id.postalCode)
        FirebaseDatabase.getInstance().getReference("users")
            .child(FirebaseAuth.getInstance().currentUser?.uid!!)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val userInfo : UserInfo = snapshot.getValue(UserInfo::class.java) ?:return
                    userName.text = userInfo.username
                    textname.text = userInfo.name
                    textsurname.text = userInfo.surname
                    age.text = userInfo.age
                    postcode.text = userInfo.postcodes


                }

                override fun onCancelled(error: DatabaseError) {
                }
            })

    }
    private fun settings(){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.Fragments_Already, Fragmentforsettings())
        transaction?.disallowAddToBackStack()
        transaction?.commit()
    }
}