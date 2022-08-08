package com.reift.recyclerview_retrofit

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reift.recyclerview_retrofit.api.data.UserItem
import com.reift.recyclerview_retrofit.databinding.ItemUserBinding

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var listUser = mutableListOf<UserItem>()

    fun setData(list: List<UserItem>){
        listUser.clear()
        listUser.addAll(list)
    }

    class UserViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    = UserViewHolder(ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        Log.i("onBindViewHolder", "onBindViewHolder: ${listUser.size} ")
        holder.binding.apply {
            tvLat.text = "Lat: "+listUser[position].address.geo.lat
            tvLong.text = "Lon: "+listUser[position].address.geo.lng
        }
    }

    override fun getItemCount() = listUser.size
}