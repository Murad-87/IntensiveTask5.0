package com.example.myintensivetask50

import androidx.fragment.app.Fragment


fun Fragment.communicator(): Communicator {
    return requireActivity() as Communicator
}

interface Communicator {

    fun launchContactDetailsFragment(id: Int, name: String, lastName: String, number: String)

    fun launchContactListFragment(id: Int, name: String, lastName: String, number: String)
}