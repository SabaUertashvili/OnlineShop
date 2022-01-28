package module

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import fragmentsforapp.fragment1.Fragment13

class AdapterViewPager(val items: ArrayList<Fragment>, activity: Fragment13) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }
}