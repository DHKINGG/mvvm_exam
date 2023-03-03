package com.example.view

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.config.BaseActivity
import com.example.data.room.Contact
import com.example.roomexam.databinding.ActivityAddBinding


class AddActivity :  BaseActivity<ActivityAddBinding>(ActivityAddBinding::inflate) {
    private lateinit var hospitalViewModel: HospitalViewModel
    private var id: Long? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainText = binding.edtAddMainText
        val title = binding.edtAddMainTitle

        hospitalViewModel = ViewModelProvider(this)[HospitalViewModel::class.java]

        if (intent != null && intent.hasExtra(EXTRA_HOSPITAL) && intent.hasExtra(EXTRA_HOSPITAL_TYPE)
            && intent.hasExtra(EXTRA_CONTACT_ID)) {
            title.setText(intent.getStringExtra(EXTRA_HOSPITAL))
            mainText.setText(intent.getStringExtra(EXTRA_HOSPITAL_TYPE))
            id = intent.getLongExtra(EXTRA_CONTACT_ID, -1)
        }

        binding.fabAdd.setOnClickListener {
            val title = binding.edtAddMainTitle.text.toString().trim()
            val mainText = binding.edtAddMainText.text.toString()

            if (title.isEmpty() || mainText.isEmpty()) {
                Toast.makeText(this, "Please enter title and mainText.", Toast.LENGTH_SHORT).show()
            } else {
                val initial = title[0].uppercaseChar()
                val contact = Contact(id, title, mainText, initial)
                hospitalViewModel.insert(contact)

                finish()
            }
        }
    }

    companion object {
        const val EXTRA_HOSPITAL = "EXTRA_HOSPITAL"
        const val EXTRA_HOSPITAL_TYPE = "EXTRA_HOSPITAL_TYPE"
        const val EXTRA_CONTACT_ID = "EXTRA_CONTACT_ID"
    }
}