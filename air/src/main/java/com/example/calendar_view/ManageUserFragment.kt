package com.example.calendar_view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class ManageUserFragment : Fragment(R.layout.fragment_manage_user) {
    var imageButton: ImageButton? = null

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        imageButton = view.findViewById<ImageButton>(R.id.btn_clear)
        imageButton?.setOnClickListener {
            navController.navigate(R.id.action_manageUserFragment_to_homeFragment)
        }
    }


}