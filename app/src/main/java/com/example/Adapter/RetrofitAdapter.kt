package com.example.Adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.room.Contact
import com.example.model.HomeBookModel
import com.example.roomexam.databinding.ItemRetrofitBinding

class RetrofitAdapter(
    val contactItemClick: (Contact) -> Unit,
    val contactItemLongClick: (Contact) -> Unit,
) : RecyclerView.Adapter<RetrofitAdapter.Holder>() {

    var list = mutableListOf<HomeBookModel>()
    lateinit var adapterContext: Context

    inner class Holder(private val binding: ItemRetrofitBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HomeBookModel) {
            binding.itemTvHospitalName.text = item.hospitalName
            binding.itemTvHospitalType.text = item.hospitalType

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        TODO("Not yet implemented")
    }

    fun setContext(context: Context) {
        adapterContext = context
    }
}