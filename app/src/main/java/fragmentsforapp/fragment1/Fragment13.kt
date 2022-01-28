package fragmentsforapp.fragment1


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.onlineshop.R

import module.AdapterViewPager


class Fragment13:Fragment(R.layout.viewpager_fragment14){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = view.findViewById<ViewPager2>(R.id.viewpager2)
        val fragments : ArrayList<Fragment> = arrayListOf(
            Fragment14(),
            Fragmentforsettings()
        )
        val adapter = AdapterViewPager(fragments,this)
        viewPager.adapter = adapter
    }



}