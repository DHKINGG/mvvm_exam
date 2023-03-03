package com.example.Adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.room.Contact
import com.example.model.HomeBookModel
import com.example.roomexam.databinding.ItemHospitalBinding



class HospitalAdapter(
    val contactItemClick: (Contact) -> Unit,
    val contactItemLongClick: (Contact) -> Unit,
) :
    RecyclerView.Adapter<HospitalAdapter.ViewHolder>() {
    private var contacts: List<Contact> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHospitalBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(contacts[position])
    }

    inner class ViewHolder(private val binding: ItemHospitalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private val hospitalName = binding.itemTvHospitalName
        private val hospitalType = binding.itemTvHospitalType
        private val initialTv = binding.itemTvInitial

        fun bind(contact: Contact) {
            hospitalName.text = contact.hospitalName
            hospitalType.text = contact.hospitalType
            initialTv.text = contact.initial.toString()

            itemView.setOnClickListener {
                contactItemClick(contact)
            }

            itemView.setOnLongClickListener {
                contactItemLongClick(contact)
                true
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setContacts(contacts: List<Contact>) {
        this.contacts = contacts
        notifyDataSetChanged()
    }

}
