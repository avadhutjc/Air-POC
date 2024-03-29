package com.example.calendar_view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.calendar_view.graphview.ColorTemplate1
import com.example.calendar_view.room.GraphDAO
import com.example.calendar_view.room.GraphDatabase
import com.example.calendar_view.room.GraphEntity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_medical_officer.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MedicalOfficerFragment : Fragment(R.layout.fragment_medical_officer), View.OnClickListener,
    AdapterView.OnItemSelectedListener {

    var imageButton: ImageButton? = null
    var imageButton1: ImageButton? = null
    var cardView: CardView? = null

    lateinit var dao: GraphDAO
    lateinit var database: GraphDatabase

    private var arrayAdapter: ArrayAdapter<String>? = null
    private var barChart: BarChart? = null
    private var barChart1: BarChart? = null
    private var barChart2: BarChart? = null

    // variable for our bar data.
    private var barData: BarData? = null

    // variable for our bar data set.
    var barDataSet: BarDataSet? = null

    // array list for storing entries.
    private var barEntriesArrayList: ArrayList<BarEntry>? = null

    private var itemList = arrayOf(
        "Last 7 days",
        "Last 14 days",
        "Last 30 days",
        "Last 60 days",
        "Custom date range",
    )

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = GraphDatabase.getGraphDatabase(requireContext())
        dao = database.getGraphDAO()

        navController = Navigation.findNavController(view)
        imageButton1 = view.findViewById(R.id.people_img_btn_back_to_medical_officer) as ImageButton
        imageButton1!!.setOnClickListener {
            navController.navigate(R.id.action_medicalOfficerFragment_to_summaryFragment)
        }
        arrayAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, itemList)
        spinners_show?.adapter = arrayAdapter
        spinners_show?.onItemSelectedListener = this

        // Drop down layout style - we get space between to list
        arrayAdapter!!.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinners_show.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                i: Int,
                l: Long
            ) {
                val intent: Intent
                when (i) {
                    1 -> {
                        intent = Intent(requireContext(), SpinnerDoing::class.java)
                        val items: String = adapterView?.getItemAtPosition(i) as String
                        Toast.makeText(requireContext(), "Selected: $items", Toast.LENGTH_LONG)
                            .show() //show toast + msg
                        startActivity(intent)
                    }

                    2 -> {
                        intent = Intent(Intent.ACTION_VIEW).setClassName(
                            "ru.slybeaver.truecalendar",
                            "ru.slybeaver.truecalendar.CalendarActivity"
                        )
                        val items: String = adapterView?.getItemAtPosition(i) as String
                        Toast.makeText(requireContext(), "Selected: $items", Toast.LENGTH_LONG)
                            .show() //show toast + msg
                        startActivity(intent)
                    }
                    3 -> {
                        intent = Intent(requireContext(), SpinnerDoing::class.java)
                        val items: String = adapterView?.getItemAtPosition(i) as String
                        Toast.makeText(requireContext(), "Selected: $items", Toast.LENGTH_LONG)
                            .show() //show toast + msg
                        startActivity(intent)
                    }
                    4 -> {
                        intent = Intent(Intent.ACTION_VIEW).setClassName(
                            "ru.slybeaver.truecalendar",
                            "ru.slybeaver.truecalendar.CalendarActivity"
                        )
                        val items: String = adapterView?.getItemAtPosition(i) as String
                        Toast.makeText(requireContext(), "Selected: $items", Toast.LENGTH_LONG)
                            .show() //show toast + msg
                        startActivity(intent)
                    }
                    5 -> {
                        intent = Intent(Intent.ACTION_VIEW).setClassName(
                            "ru.slybeaver.truecalendar",
                            "ru.slybeaver.truecalendar.CalendarActivity"
                        )
                        val items: String = adapterView?.getItemAtPosition(i) as String
                        Toast.makeText(requireContext(), "Selected: $items", Toast.LENGTH_LONG)
                            .show() //show toast + msg
                        startActivity(intent)
                    }

                }
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                Toast.makeText(requireContext(), "Nothing Select", Toast.LENGTH_SHORT).show()
            }
        }

        cardView = view.findViewById<View>(R.id.card) as CardView
        cardView!!.setOnClickListener {
            navController.navigate(R.id.action_medicalOfficerFragment_to_medicalOfficerPracticeSessionFragment)
        }

        cardView = view.findViewById<View>(R.id.card_view_avg_ev_duration) as CardView
        cardView?.setOnClickListener {
            navController.navigate(R.id.action_medicalOfficerFragment_to_medicalOfficerPracticeSessionFragment)
        }

        cardView = view.findViewById<View>(R.id.home_frag_chart_ev_duration2_med_officer) as CardView
        cardView?.setOnClickListener {
            navController.navigate(R.id.action_medicalOfficerFragment_to_medicalOfficerFirstEvFragment)
        }

        imageButton = view.findViewById<View>(R.id.switch_img_btn_medical_officer) as ImageButton
        imageButton?.setOnClickListener {
            // Create custom dialog object
            val dialog = Dialog(this.requireContext())
            // Include dialog.xml file
            dialog.setContentView(R.layout.dialog2)
            dialog.setTitle("Custom Dialog")

            val text = dialog.findViewById<View>(R.id.textDialog) as TextView
            text.text = "Savitri Rathod"
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ActionMenuView.LayoutParams.WRAP_CONTENT
            )
            dialog.show()

            val relativeLayout1 =
                dialog.findViewById<View>(R.id.birth_attendant_dialog) as RelativeLayout
            relativeLayout1.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "You Cannot Switch To Birth Attendant Account",
                    Toast.LENGTH_LONG
                ).show()
            }

            val relativeLayout2 = dialog.findViewById<View>(R.id.midwife_dialog) as RelativeLayout
            relativeLayout2.setOnClickListener {
                navController.navigate(R.id.action_medicalOfficerFragment_to_midWifeFragment) // -> onclick of btn will open any fragment assign
                dialog.dismiss()
            }

            val relativeLayout3 =
                dialog.findViewById<View>(R.id.medical_officer_dialog) as RelativeLayout
            relativeLayout3.setOnClickListener {
                navController.navigate(R.id.action_medicalOfficerFragment_self)
                dialog.dismiss()
            }

            val manageUserTextview =
                dialog.findViewById<View>(R.id.btn_manage_user_medical_officer) as TextView
            manageUserTextview.setOnClickListener {
                navController.navigate(R.id.action_medicalOfficerFragment_to_manageUserFragment) // -> onclick of btn will open any fragment assign
                dialog.dismiss()
            }
        }

        Log.d("check", "AnotherBarActivity is running")
        //    barChart = view.findViewById<BarChart>(R.id.chart_in_home_frag) -> show wrong initialization
//        barChart1 = view.findViewById(R.id.home_frag_chart_ev_duration11) //-> show correct initialization
//        barChart2 = view.findViewById(R.id.home_frag_chart_ev_duration2)

        barChart = view.findViewById(R.id.home_frag_chart_home) //-> show correct initialization
        getBarEntries()
        barDataSet = BarDataSet(barEntriesArrayList, "First graph")
        barData = BarData(barDataSet)
      //  home_frag_chart_home?.data = barData
        home_frag_chart_ev_duration11?.data = barData
        home_frag_chart_ev_duration2?.data = barData

        barChart?.data = barData
//        barChart2?.data = barData
        //  barDataSet?.setColors(*ColorTemplate.MATERIAL_COLORS) ->read only colors ->adding color to our bar data set.
        barDataSet?.setColors(*ColorTemplate1.MATERIAL_COLORS1) //read and write only colors

    }

    private fun getBarEntries() {
        barEntriesArrayList = ArrayList<BarEntry>()
        Log.d("check_bar", "getBarEntries function called")

        barEntriesArrayList!!.add(BarEntry(1f, 4f))
        barEntriesArrayList!!.add(BarEntry(2f, 6f))
        barEntriesArrayList!!.add(BarEntry(3f, 5f))
        barEntriesArrayList!!.add(BarEntry(4f, 2f))
        barEntriesArrayList!!.add(BarEntry(5f, 4f))
        barEntriesArrayList!!.add(BarEntry(6f, 1f))
        barEntriesArrayList!!.add(BarEntry(7f, 3f))

        val pushToEntity1 = GraphEntity(10f, 11f)

        CoroutineScope(Dispatchers.IO).launch {
            dao.register(pushToEntity1)
        }

/*
        CoroutineScope(Dispatchers.IO).launch {
            val pointsOnGraph = dao.getUser()

            CoroutineScope(Dispatchers.Main).launch {
                pointsOnGraph.forEach {
                    barEntriesArrayList!!.add(BarEntry(it.xPoints, it.yPoints))
                    Log.d("check_graph_forx", it.xPoints.toString())
                    Log.d("check_graph_fory", it.yPoints.toString())
                }
            }
        }
*/

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_detail -> {
                //           navController.navigate(R.id.action_homeFragment_to_manageUserFragment)
                val intent = Intent(Intent.ACTION_VIEW).setClassName(
                    "ru.slybeaver.truecalendar", "ru.slybeaver.truecalendar.CalendarActivity"
                )
                startActivity(intent)
            }
        }
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(arg0: AdapterView<*>?) {
    }

}