package com.example.myintensivetask50.ui

import android.os.Bundle
import android.view.View
import com.example.myintensivetask50.communicator
import com.example.myintensivetask50.databinding.FragmentContactDetailsBinding
import com.example.myintensivetask50.utils.BaseFragment

class ContactDetailsFragment :
    BaseFragment<FragmentContactDetailsBinding>(FragmentContactDetailsBinding::inflate) {

    private var id: Int? = null
    private var name: String? = null
    private var lastName: String? = null
    private var number: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            id = it.getInt(ARGUMENT_ID)
            name = it.getString(ARGUMENT_NAME)
            lastName = it.getString(ARGUMENT_LAST_NAME)
            number = it.getString(ARGUMENT_NUMBER)
        }

        with(binding) {
            editName.setText(name)
            editLastName.setText(lastName)
            editNumber.setText(number)

            button.setOnClickListener {
                communicator().launchContactListFragment(
                    id = id ?: 1,
                    name = editName.text.toString(),
                    lastName = editLastName.text.toString(),
                    number = editNumber.text.toString()
                )
            }
        }
    }

    companion object {

        private const val ARGUMENT_ID = "ARGUMENT_ID"
        private const val ARGUMENT_NAME = "ARGUMENT_NAME"
        private const val ARGUMENT_LAST_NAME = "ARGUMENT_LAST_NAME"
        private const val ARGUMENT_NUMBER = "ARGUMENT_NUMBER"

        fun newInstance(id: Int, name: String, lastName: String, number: String) =
            ContactDetailsFragment()
                .apply {
                    arguments = Bundle().apply {
                        putInt(ARGUMENT_ID, id)
                        putString(ARGUMENT_NAME, name)
                        putString(ARGUMENT_LAST_NAME, lastName)
                        putString(ARGUMENT_NUMBER, number)
                    }
                }
    }
}