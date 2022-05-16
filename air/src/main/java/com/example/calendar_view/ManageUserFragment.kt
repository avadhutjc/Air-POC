package com.example.calendar_view

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation

class ManageUserFragment : Fragment(R.layout.fragment_manage_user) {
    var imageButton: ImageButton? = null
    var imageButton1: ImageButton? = null
    var textView: TextView? = null

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        imageButton1 = view.findViewById<ImageButton>(R.id.btn_clear_user_list)
        imageButton1?.setOnClickListener {
            navController.navigate(R.id.action_manageUserFragment_to_midWifeFragment)
        }
        /* imageButton = view.findViewById<View>(R.id.delete_img1) as ImageButton
         imageButton!!.setOnClickListener {
             // Create custom dialog object


             val dialog = AlertDialog.Builder(requireContext())
             dialog.setTitle("Delete user?")
             dialog.setMessage("If you delete a user, they will not be able to see their practice sessions.")
             dialog.setPositiveButton("YES", DialogInterface.OnClickListener { dialog, which ->
                 Toast.makeText(requireContext(), "Hello", Toast.LENGTH_SHORT).show()
                 dialog.dismiss()
             })
             dialog.setNegativeButton(
                 "No, GO BACK",
                 DialogInterface.OnClickListener { dialog, which ->
                     dialog.dismiss()
                 })
             dialog.show()
         }*/

//operation for first button

        imageButton = view.findViewById<View>(R.id.delete_img1) as ImageButton
        imageButton!!.setOnClickListener {
            // Create custom dialog object
            val dialog = Dialog(this.requireContext())
            // Include dialog.xml file
            dialog.setContentView(R.layout.delete_user_alert_dialog_box)
            dialog.setTitle("Custom Dialog")

            val text = dialog.findViewById<View>(R.id.textDialog) as TextView
            text.text = "Delete user?"
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ActionMenuView.LayoutParams.WRAP_CONTENT
            )
            dialog.show()

            val textView1 = dialog.findViewById<View>(R.id.txt_goBack) as TextView
            textView1.setOnClickListener {
                navController.navigate(R.id.action_manageUserFragment_self)
                dialog.dismiss()
            }

            textView = dialog.findViewById<View>(R.id.txt_Yes) as TextView
            textView?.setOnClickListener {
                dialog.setContentView(R.layout.confirm_delete_user_alert_dialog_box)
                dialog.setTitle("Custom Dialog")

                val text1 = dialog.findViewById<View>(R.id.confirm_textDialog) as TextView
                text1.text = "Are you sure?"
                dialog.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ActionMenuView.LayoutParams.WRAP_CONTENT
                )
                dialog.show()

                val textView2 =
                    dialog.findViewById<View>(R.id.txt_goBack_from_irreversible_action) as TextView
                textView2.setOnClickListener {
                    navController.navigate(R.id.action_manageUserFragment_self)
                    dialog.dismiss()
                }

                val textView3 =
                    dialog.findViewById<View>(R.id.txt_Yes_from_irreversible_action) as TextView
                textView3.setOnClickListener {
                    navController.navigate(R.id.action_manageUserFragment_self)
                    Toast.makeText(requireContext(), "User Deleted Successfully", Toast.LENGTH_LONG)
                        .show()
                    dialog.dismiss()
                }
            }
        }
//operation for second button
        imageButton = view.findViewById<View>(R.id.delete_img2) as ImageButton
        imageButton!!.setOnClickListener {
            val dialog = Dialog(this.requireContext())
            dialog.setContentView(R.layout.delete_user_alert_dialog_box)
            dialog.setTitle("Custom Dialog")

            val text = dialog.findViewById<View>(R.id.textDialog) as TextView
            text.text = "Delete user?"
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ActionMenuView.LayoutParams.WRAP_CONTENT
            )
            dialog.show()

            val textView1 = dialog.findViewById<View>(R.id.txt_goBack) as TextView
            textView1.setOnClickListener {
                navController.navigate(R.id.action_manageUserFragment_self)
                dialog.dismiss()
            }

            textView = dialog.findViewById<View>(R.id.txt_Yes) as TextView
            textView?.setOnClickListener {
                dialog.setContentView(R.layout.confirm_delete_user_alert_dialog_box)
                dialog.setTitle("Custom Dialog")

                val text1 = dialog.findViewById<View>(R.id.confirm_textDialog) as TextView
                text1.text = "Are you sure?"
                dialog.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ActionMenuView.LayoutParams.WRAP_CONTENT
                )
                dialog.show()

                val textView2 =
                    dialog.findViewById<View>(R.id.txt_goBack_from_irreversible_action) as TextView
                textView2.setOnClickListener {
                    navController.navigate(R.id.action_manageUserFragment_self)
                    dialog.dismiss()
                }

                val textView3 =
                    dialog.findViewById<View>(R.id.txt_Yes_from_irreversible_action) as TextView
                textView3.setOnClickListener {
                    navController.navigate(R.id.action_manageUserFragment_self)
                    Toast.makeText(requireContext(), "User Deleted Successfully", Toast.LENGTH_LONG)
                        .show()
                    dialog.dismiss()
                }
            }
        }

//operation for third button
        imageButton = view.findViewById<View>(R.id.delete_img3) as ImageButton
        imageButton!!.setOnClickListener {
            val dialog = Dialog(this.requireContext())
            dialog.setContentView(R.layout.delete_user_alert_dialog_box)
            dialog.setTitle("Custom Dialog")

            val text = dialog.findViewById<View>(R.id.textDialog) as TextView
            text.text = "Delete user?"
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ActionMenuView.LayoutParams.WRAP_CONTENT
            )
            dialog.show()

            val textView1 = dialog.findViewById<View>(R.id.txt_goBack) as TextView
            textView1.setOnClickListener {
                navController.navigate(R.id.action_manageUserFragment_self)
                dialog.dismiss()
            }

            textView = dialog.findViewById<View>(R.id.txt_Yes) as TextView
            textView?.setOnClickListener {
                dialog.setContentView(R.layout.confirm_delete_user_alert_dialog_box)
                dialog.setTitle("Custom Dialog")

                val text1 = dialog.findViewById<View>(R.id.confirm_textDialog) as TextView
                text1.text = "Are you sure?"
                dialog.window?.setLayout(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ActionMenuView.LayoutParams.WRAP_CONTENT
                )
                dialog.show()

                val textView2 =
                    dialog.findViewById<View>(R.id.txt_goBack_from_irreversible_action) as TextView
                textView2.setOnClickListener {
                    navController.navigate(R.id.action_manageUserFragment_self)
                    dialog.dismiss()
                }

                val textView3 =
                    dialog.findViewById<View>(R.id.txt_Yes_from_irreversible_action) as TextView
                textView3.setOnClickListener {
                    navController.navigate(R.id.action_manageUserFragment_self)
                    Toast.makeText(requireContext(), "User Deleted Successfully", Toast.LENGTH_LONG)
                        .show()
                    dialog.dismiss()
                }
            }
        }
    }
}