package com.example.myintensivetask50.ui

import android.os.Bundle
import android.view.View
import com.example.myintensivetask50.communicator
import com.example.myintensivetask50.databinding.FragmentContactListBinding
import com.example.myintensivetask50.utils.BaseFragment

class ContactListFragment :
    BaseFragment<FragmentContactListBinding>(FragmentContactListBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            when (it.getInt(ARGUMENT_ID)) {
                1 -> {
                    binding.name1.text = it.getString(ARGUMENT_NAME)
                    binding.lastName1.text = it.getString(ARGUMENT_LAST_NAME)
                    binding.number1.text = it.getString(ARGUMENT_NUMBER)
                }
                2 -> {
                    binding.name2.text = it.getString(ARGUMENT_NAME)
                    binding.lastName2.text = it.getString(ARGUMENT_LAST_NAME)
                    binding.number2.text = it.getString(ARGUMENT_NUMBER)
                }
                3 -> {
                    binding.name3.text = it.getString(ARGUMENT_NAME)
                    binding.lastName3.text = it.getString(ARGUMENT_LAST_NAME)
                    binding.number3.text = it.getString(ARGUMENT_NUMBER)
                }
                4 -> {
                    binding.name4.text = it.getString(ARGUMENT_NAME)
                    binding.lastName4.text = it.getString(ARGUMENT_LAST_NAME)
                    binding.number4.text = it.getString(ARGUMENT_NUMBER)
                }
            }
        }

        with(binding) {
            contact1.setOnClickListener {
                communicator().launchContactDetailsFragment(
                    id = 1,
                    name = name1.text.toString(),
                    lastName = lastName1.text.toString(),
                    number = number1.text.toString()
                )
            }

            contact2.setOnClickListener {
                communicator().launchContactDetailsFragment(
                    id = 2,
                    name = name2.text.toString(),
                    lastName = lastName2.text.toString(),
                    number = number2.text.toString()
                )
            }

            contact3.setOnClickListener {
                communicator().launchContactDetailsFragment(
                    id = 3,
                    name = name3.text.toString(),
                    lastName = lastName3.text.toString(),
                    number = number3.text.toString()
                )
            }

            contact4.setOnClickListener {
                communicator().launchContactDetailsFragment(
                    id = 4,
                    name = name4.text.toString(),
                    lastName = lastName4.text.toString(),
                    number = number4.text.toString()
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
            ContactListFragment()
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
