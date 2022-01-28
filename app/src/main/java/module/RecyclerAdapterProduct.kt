package module

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlineshop.R

class RecyclerAdapterProduct (private val productlist : List<product>):
    RecyclerView.Adapter<RecyclerAdapterProduct.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var imageView: ImageView = itemView.findViewById(R.id.imageView2Rec)
        var textView: TextView= itemView.findViewById(R.id.textView6)
        var textView2: TextView= itemView.findViewById(R.id.textView7)


        fun setdata(product: product){
            textView.text = product.description
            textView2.text = product.price
            Glide.with(itemView).load(product.imageURL).into(imageView)

        }
        
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_pr,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.setdata(productlist[position])
    }

    override fun getItemCount(): Int {
        return productlist.size
    }
}