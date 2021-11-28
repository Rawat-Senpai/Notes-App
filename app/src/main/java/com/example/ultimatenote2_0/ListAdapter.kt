package com.example.ultimatenote2_0

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view.view.*


class ListAdapter: RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var userList = emptyList<User>()


    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = userList[position]

        holder.itemView.itemTitle.text=currentItem.lastNote
        holder.itemView.itemBody.text=currentItem.nameTitle
        holder.itemView.rowLayout.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()))

        holder.itemView.rowLayout.setOnClickListener(){

            val action=list_FragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user:List<User> ){
        this.userList=user
        notifyDataSetChanged()

    }
}