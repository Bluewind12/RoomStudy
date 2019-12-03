package momonyan.roomstudy.recycler_view_content

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import momonyan.roomstudy.R

class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    // 独自に作成したListener
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val nameTextView: TextView = view.findViewById(R.id.recyclerItemNameText)
    val ageTextView: TextView = view.findViewById(R.id.recyclerItemAgeText)
    val genderTextView: TextView = view.findViewById(R.id.recyclerItemGenderText)
    val hobbyTextView: TextView = view.findViewById(R.id.recyclerItemHobbyText)

}