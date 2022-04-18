package com.example.myintensivetask50

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myintensivetask50.databinding.ActivityMainBinding
import com.example.myintensivetask50.ui.ContactDetailsFragment
import com.example.myintensivetask50.ui.ContactListFragment


class MainActivity : AppCompatActivity(), Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.activity_frame_layout, ContactListFragment())
            .commit()
    }

    override fun launchContactDetailsFragment(
        id: Int,
        name: String,
        lastName: String,
        number: String
    ) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(
                R.id.activity_frame_layout,
                ContactDetailsFragment.newInstance(
                    id = id,
                    name = name,
                    lastName = lastName,
                    number = number
                )
            )
            .commit()
    }

    override fun launchContactListFragment(
        id: Int,
        name: String,
        lastName: String,
        number: String
    ) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.activity_frame_layout,
                ContactListFragment.newInstance(
                    id = id,
                    name = name,
                    lastName = lastName,
                    number = number
                )
            )
            .addToBackStack(null)
            .commit()
    }
}