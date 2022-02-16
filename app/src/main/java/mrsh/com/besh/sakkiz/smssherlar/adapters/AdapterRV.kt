package mrsh.com.besh.sakkiz.smssherlar.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_sherlar_uchun_rv.view.*

import mrsh.com.besh.sakkiz.smssherlar.DataClass
import mrsh.com.besh.sakkiz.smssherlar.R
import mrsh.com.besh.sakkiz.smssherlar.utils.ItemTouchHelperAdapter
import java.util.*
import kotlin.collections.ArrayList

class AdapterRV(
    var context: Context,
    var rvItemClick: RvItemClick,
    var arrayList: ArrayList<DataClass>
) : RecyclerView.Adapter<AdapterRV.VH>() {

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView), ItemTouchHelperAdapter {
        fun onBind(string: DataClass, position: Int) {

            itemView.sherNomi.text = string.shernomi
            itemView.sher.text  = string.sher

            itemView.rv_card_item.setOnClickListener{
                rvItemClick.onClick(string,position)
            }

        }

        override fun onItemMove(fromPosition: Int, toPosition: Int) {
            if (fromPosition < toPosition) {
                for (i in fromPosition until toPosition) {
                    Collections.swap(arrayList, i, i + 1)
                }
            } else {
                for (i in fromPosition downTo toPosition + 1) {
                    Collections.swap(arrayList, i, i - 1)
                }
            }
            notifyItemMoved(fromPosition, toPosition)
        }

        override fun onItemDismiss(position: Int) {
            arrayList.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_sherlar_uchun_rv, parent, false)
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(arrayList[position], position)
    }

    override fun getItemCount(): Int = arrayList.size


    interface RvItemClick {
        fun onClick(dataClass: DataClass, position: Int)
    }


}
