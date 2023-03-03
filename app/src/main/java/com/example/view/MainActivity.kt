package com.example.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.config.BaseActivity
import com.example.data.room.Contact
import com.example.Adapter.HospitalAdapter
import com.example.roomexam.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private val hospitalViewModel by lazy {
        ViewModelProvider(this,HospitalViewModel.Factory(application))[HospitalViewModel::class.java]
        //viewModel을 생성하는 방법 검색 , lazy같은것동
        //팩토리 따로 객체 생성
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val hospitalAdapter = HospitalAdapter({ contact ->
            val intent = Intent(this, AddActivity::class.java)
            intent.putExtra(AddActivity.EXTRA_HOSPITAL, contact.hospitalName)
            intent.putExtra(AddActivity.EXTRA_HOSPITAL_TYPE, contact.hospitalType)
            intent.putExtra(AddActivity.EXTRA_CONTACT_ID, contact.id)
            startActivity(intent)
        }, { contact ->
            deleteDialog(contact)
        })

        hospitalViewModel.getHome()


        val lm = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val rv = binding.rvMain
        val fab = binding.fabAddHospital
        rv.adapter = hospitalAdapter
        rv.layoutManager = lm
        rv.setHasFixedSize(true)

        hospitalViewModel.getAll().observe(this, Observer<List<Contact>> { contacts ->
            hospitalAdapter.setContacts(contacts!!)
        })

        fab.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }




    private fun deleteDialog(contact: Contact) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Delete selected info?")
            .setNegativeButton("NO") { _, _ -> }
            .setPositiveButton("YES") { _, _ ->
                hospitalViewModel.delete(contact)
            }
        builder.show()
    }
}


