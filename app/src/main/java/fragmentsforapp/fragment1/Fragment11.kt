package fragmentsforapp.fragment1

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshop.R
import com.example.onlineshop.fragmentslogin.Fragment3
import module.RecyclerAdapterProduct
import module.product

class Fragment11 : Fragment(R.layout.home_fragment){


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView= view.findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = RecyclerAdapterProduct(getproduct())


    }
    private fun getproduct(): List<product> {
        val productlist  = ArrayList<product>()

        productlist.add(
            product(
                description = "(2x8) Adata Z1 16GB 3000MHz",
                imageURL = "https://scontent.ftbs5-2.fna.fbcdn.net/v/t1.15752-9/272112420_454675016374017_6588862207149342892_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=ae9488&_nc_eui2=AeHO62C8J3Eb5onLZLMBpmy4lEDkvuG8ANqUQOS-4bwA2hweJHbqVzJA30KprENOG8f1z1yuhtL72VoFCvQxw3VK&_nc_ohc=ew9r8bYu33gAX97ZXEJ&_nc_ht=scontent.ftbs5-2.fna&oh=03_AVI-FYHpoMSEdW5J0yMgHJXeAIgvcvVxeLTE2P1ADxeejA&oe=6215F784",
                price = "200 $"
            )
        )
        productlist.add(
            product(
                description = "RTX 3090",
                imageURL = "https://scontent.ftbs5-3.fna.fbcdn.net/v/t1.15752-9/272031475_350690923562716_339952894817528121_n.jpg?_nc_cat=102&ccb=1-5&_nc_sid=ae9488&_nc_eui2=AeHabzQr8hMhB5jf-dsBFXcZx-4hqoLmqMvH7iGqguaoyxLsNlJK3OMrjgtoDUj2MpE1r-VXmOSPVOlABkFnEJnF&_nc_ohc=QOUtzoZG-zkAX9yoUou&_nc_ht=scontent.ftbs5-3.fna&oh=03_AVI-5KjbZL4IOa5T9nlcW7_mWf9WPqepP67dF5y2wCsl0w&oe=62128DA7",
                price = "2000 $"
            )
        )
        productlist.add(
            product(
                description = "RTX 3070",
                imageURL = "https://scontent.ftbs5-2.fna.fbcdn.net/v/t1.15752-9/s2048x2048/272119973_331178258886461_1903205150576695873_n.jpg?_nc_cat=100&ccb=1-5&_nc_sid=ae9488&_nc_eui2=AeEqZZEuh1NGJv8K8awn0GqdTAK_OJLl3YxMAr84kuXdjPgbsuvsnA2Fu5jkZzU_Ke7xJAhKtd5mos-fhLg6zBp7&_nc_ohc=lY9b_e-poJgAX-yOPwz&_nc_ht=scontent.ftbs5-2.fna&oh=03_AVIImSmBg_UGq2HWpA3uiCTK51NJ8TTqPXT7n8Pj8JvXOA&oe=6214AA2A",
                price = "2500 $"
            )
        )
        productlist.add(
            product(
                description = "G.SKILL 16GB (2x8) 3000MHz",
                imageURL = "https://scontent.ftbs5-2.fna.fbcdn.net/v/t1.15752-9/270022190_617798979484874_3222329941332171562_n.jpg?_nc_cat=104&ccb=1-5&_nc_sid=ae9488&_nc_eui2=AeFc6XYyeL3i0p-YNSG49LAxKwVxj5D_2ksrBXGPkP_aSx61oVf2wtvym4jIQsLSK6zWB-NkVumrJGsspzobioGz&_nc_ohc=EBRMjwtOnXIAX_L66rm&_nc_ht=scontent.ftbs5-2.fna&oh=03_AVLw-PGnD_BNoekutJjmkT0WPHx95Th_jialZrhVP_m2KQ&oe=62154009",
                price = "200 $"
            )
        )
        productlist.add(
            product(
                description = "Samsung 980 PRO SSD 1TB",
                imageURL = "https://scontent.ftbs5-2.fna.fbcdn.net/v/t1.15752-9/272182911_454914656282225_2248827036557748257_n.jpg?_nc_cat=110&ccb=1-5&_nc_sid=ae9488&_nc_eui2=AeGJzJ9QLK_h8cSCeZvfVWylFgP8QeGizEUWA_xB4aLMRRfJqeujmQ2gJBBrD44gATJaE9QFwqR3QqmfO8dfeTsA&_nc_ohc=p2Zhrn90MzkAX-wBm5s&_nc_ht=scontent.ftbs5-2.fna&oh=03_AVIjYCsHnQuMg_FsTdZMYb_CLST3Ck839EjUvFWJaX9Rdw&oe=62156DAD",
                price = "700 $"
            )
        )


        return productlist
    }

}