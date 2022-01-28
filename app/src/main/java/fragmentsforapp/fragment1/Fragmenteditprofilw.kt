package fragmentsforapp.fragment1

import android.app.Activity
import android.content.Intent

import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

import androidx.fragment.app.Fragment

import com.example.onlineshop.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.mikhaellopez.circularimageview.CircularImageView
import kotlinx.android.synthetic.main.editprofile_fragment.*
import kotlinx.android.synthetic.main.profile_fragment.*
import module.UserInfo

import java.util.*


class Fragmenteditprofilw : Fragment(R.layout.editprofile_fragment) {
    private lateinit var profileimage : CircularImageView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val save = view.findViewById<Button>(R.id.save_btn)
        save.setOnClickListener {
            val editText = view.findViewById<EditText>(R.id.firstnameEdit)
            val editlast = view.findViewById<EditText>(R.id.lastnameEdit)
            val username = view.findViewById<EditText>(R.id.username22)
            val age1 = view.findViewById<EditText>(R.id.age16)
            val postcode = view.findViewById<EditText>(R.id.EmailEdit)
            val name = editText.text.toString()
            val surname = editlast.text.toString()
            val age = age1.text.toString()
            val postcodet = postcode.text.toString()
            val usernime = username.text.toString()



            val user = UserInfo(usernime,name,surname,age,postcodet)
            val asaki = age.toInt()
            if (asaki < 18){
                age1.error = "age should be 18 or more"
                return@setOnClickListener
            }

            if (postcodet.length <4){
                postcode.error = "post code should be 4 character"
                return@setOnClickListener

            }
            if (name.isEmpty()||surname.isEmpty()||age.isEmpty()||postcodet.isEmpty()||usernime.isEmpty()){
                Toast.makeText(activity, "Fill all field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
                myaccount()

            }else{
                FirebaseDatabase.getInstance().getReference("users").child(
                    FirebaseAuth.getInstance().currentUser?.uid!!
                ).setValue(user)
                uploadimage()

                myaccount()

            }


        }
        val imageback = view.findViewById<ImageView>(R.id.editBack)
        imageback.setOnClickListener{
            tosettings()
        }
        val imageButton = view.findViewById<ImageView>(R.id.imageViewBtn)

        imageButton.setOnClickListener {

            var sxvintent = Intent(Intent.ACTION_PICK)
            sxvintent.type = "image/*"
            startActivityForResult(sxvintent,456)


        }

    }

    var uri : Uri? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 456 && resultCode == Activity.RESULT_OK && data != null){
            uri = data.data

            val Bitmap = MediaStore.Images.Media.getBitmap(activity?.contentResolver,uri)
            imageViewBtn.setImageBitmap(Bitmap)


        }
    }
    private fun myaccount (){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.Fragments_Already, Fragment14())
        transaction?.disallowAddToBackStack()
        transaction?.commit()

    }
    private fun uploadimage(){
        if (uri == null)return
        val filename = UUID.randomUUID().toString()
        val storage = FirebaseStorage.getInstance().getReference("/image/")
            .child(FirebaseAuth.getInstance().currentUser?.uid!!).child("profile picture/$filename")
        storage.putFile(uri!!)

    }
    private fun tosettings (){
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.Fragments_Already, Fragmentforsettings())
        transaction?.disallowAddToBackStack()
        transaction?.commit()

    }






}