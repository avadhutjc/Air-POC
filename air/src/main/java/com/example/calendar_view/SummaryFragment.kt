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
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_summary.*

class SummaryFragment : Fragment(R.layout.fragment_summary), View.OnClickListener,
    AdapterView.OnItemSelectedListener {

    var imageButton: ImageButton? = null
    var imageButton1: ImageButton? = null
    var cardView: CardView? = null
    var cardView1: CardView? = null

    private var arrayAdapter: ArrayAdapter<String>? = null

    // variable for our bar chart
    private var barChart: BarChart? = null
    private var barChart1: BarChart? = null
    private var barChart2: BarChart? = null

    // variable for our bar data.
    var barData: BarData? = null

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

        navController = Navigation.findNavController(view)

        arrayAdapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, itemList)
        spinners_show?.adapter = arrayAdapter
        spinners_show?.onItemSelectedListener = this

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

        cardView = view.findViewById<View>(R.id.summary_practice_session) as CardView
        cardView!!.setOnClickListener {
            navController.navigate(R.id.action_summaryFragment_to_summaryPracticeSessionFragment)
        }

        cardView = view.findViewById<View>(R.id.card_view_avg_ev_duration) as CardView
        cardView?.setOnClickListener {
        }

        imageButton1 = view.findViewById(R.id.people_img_btn_back_to_home) as ImageButton
        imageButton1!!.setOnClickListener {
            navController.navigate(R.id.action_summaryFragment_to_midWifeFragment)
        }

        imageButton = view.findViewById<View>(R.id.switch_img_btn) as ImageButton
        imageButton!!.setOnClickListener {
            // Create custom dialog object
            val dialog = Dialog(this.requireContext())
            // Include dialog.xml file
            dialog.setContentView(R.layout.dialog1)
            dialog.setTitle("Custom Dialog")

            val text = dialog.findViewById<View>(R.id.textDialog) as TextView
            text.text = "Shushma Kumar"
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ActionMenuView.LayoutParams.WRAP_CONTENT)
            dialog.show()

            val relativeLayout3 = dialog.findViewById<View>(R.id.rel1) as RelativeLayout
            relativeLayout3.setOnClickListener {
                navController.navigate(R.id.action_summaryFragment_to_midWifeFragment)
                dialog.dismiss()
            }

            val relativeLayout2 = dialog.findViewById<View>(R.id.rel11) as RelativeLayout
            relativeLayout2.setOnClickListener {
                navController.navigate(R.id.action_summaryFragment_to_medicalOfficerFragment) // -> onclick of btn will open any fragment assign
                dialog.dismiss()
            }

            val relativeLayout13 = dialog.findViewById<View>(R.id.rel111) as RelativeLayout
            relativeLayout13.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "You Cannot Switch To Birth Attendant Account",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

        Log.d("check", "AnotherBarActivity is running")
        //    barChart = view.findViewById<BarChart>(R.id.chart_in_home_frag) -> show wrong initialization
        barChart = view.findViewById(R.id.home_frag_chart_home) //-> show correct initialization
        barChart1 =
            view.findViewById(R.id.home_frag_chart_ev_duration11) //-> show correct initialization
        barChart2 = view.findViewById(R.id.home_frag_chart_ev_duration2)
        getBarEntries()
        barDataSet = BarDataSet(barEntriesArrayList, "")
        barData = BarData(barDataSet)
        barChart?.data = barData
        barChart1?.data = barData
        barChart2?.data = barData
        // adding color to our bar data set.
        //  barDataSet?.setColors(*ColorTemplate.MATERIAL_COLORS) ->read only colors
        barDataSet?.setColors(*ColorTemplate1.MATERIAL_COLORS1) //read and write only colors

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

    private fun getBarEntries() {
        // creating a new array list
        barEntriesArrayList = java.util.ArrayList<BarEntry>()
        Log.d("check_bar", "getBarEntries function called")

        barEntriesArrayList!!.add(BarEntry(1f, 4f))
        barEntriesArrayList!!.add(BarEntry(2f, 6f))
        barEntriesArrayList!!.add(BarEntry(3f, 5f))
        barEntriesArrayList!!.add(BarEntry(4f, 2f))
        barEntriesArrayList!!.add(BarEntry(5f, 4f))
        barEntriesArrayList!!.add(BarEntry(6f, 1f))
        barEntriesArrayList!!.add(BarEntry(7f, 3f))
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(arg0: AdapterView<*>?) {
    }

}