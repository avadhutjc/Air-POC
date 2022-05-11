package com.example.calendar_view

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar_view.room.GraphDAO
import com.example.calendar_view.room.GraphDatabase
import com.example.calendar_view.room.GraphEntity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_mid_wife.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MidWifeFragment : Fragment(R.layout.fragment_mid_wife), View.OnClickListener,
    AdapterView.OnItemSelectedListener {

    var imageButton: ImageButton? = null
    var imageButton1: ImageButton? = null
    var cardView: CardView? = null
    lateinit var dao: GraphDAO
    lateinit var database: GraphDatabase

    private var arrayAdapter: ArrayAdapter<String>? = null

    private var recyclerView: RecyclerView? = null

    //   private val studentList = mutableListOf<Student>()
    private val studentList = arrayListOf<Student>()

    // variable for our bar chart
    private var chart: BarChart? = null
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
            navController.navigate(R.id.action_midWifeFragment_to_midWifePracticeSessionFragment) // -> onclick of btn will open any fragment assign
        }

        cardView = view.findViewById<View>(R.id.card_view_avg_ev_duration) as CardView
        cardView?.setOnClickListener {
            navController.navigate(R.id.action_midWifeFragment_to_midWifeEvDurationFragment) // -> onclick of btn will open any fragment assign
        }

        cardView = view.findViewById<View>(R.id.card_view_avg_ev_duration2) as CardView
        cardView?.setOnClickListener {
            navController.navigate(R.id.action_midWifeFragment_to_firstEvMidWifeFragment) // -> onclick of btn will open any fragment assign
        }

        imageButton1 = view.findViewById(R.id.people_img_btn_summary) as ImageButton
        imageButton1!!.setOnClickListener {
            navController.navigate(R.id.action_midWifeFragment_to_summaryFragment)
        }

        imageButton = view.findViewById<View>(R.id.switch_img_btn) as ImageButton
        imageButton!!.setOnClickListener {
            // Create custom dialog object
            val dialog = Dialog(this.requireContext())
            // Include dialog.xml file
            dialog.setContentView(R.layout.dialog)
            dialog.setTitle("Custom Dialog")

            val text = dialog.findViewById<View>(R.id.textDialog) as TextView
            text.text = "Shushma Kumar"
           // dialog.getWindow()?.setLayout(1300, 1400); //Controlling width and height.
            // below this show your dialog box match parent fit to any screen
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ActionMenuView.LayoutParams.WRAP_CONTENT)
            dialog.show()


            val relativeLayout1 = dialog.findViewById<View>(R.id.rel111) as RelativeLayout
            relativeLayout1.setOnClickListener {
                Toast.makeText(
                    requireContext(),
                    "You Cannot Switch To Birth Attendant Account",
                    Toast.LENGTH_LONG
                ).show()
            }

            val relativeLayout2 = dialog.findViewById<View>(R.id.rel11) as RelativeLayout
            relativeLayout2.setOnClickListener {
                navController.navigate(R.id.action_midWifeFragment_to_medicalOfficerFragment) // -> onclick of btn will open any fragment assign
                dialog.dismiss()
            }

            val relativeLayout3 = dialog.findViewById<View>(R.id.rel1) as RelativeLayout
            relativeLayout3.setOnClickListener {
                navController.navigate(R.id.action_midwifeFragment_self)
                dialog.dismiss()
            }

            val manageUserTextview = dialog.findViewById<View>(R.id.btn_manage_user) as TextView
            manageUserTextview.setOnClickListener {
                navController.navigate(R.id.action_midWifeFragment_to_manageUserFragment) // -> onclick of btn will open any fragment assign
                dialog.dismiss()
            }

        }

        chart = view.findViewById(R.id.home_frag_chart_midwife) //-> show correct initialization
        getBarEntries()
        val barDataSet = BarDataSet(barEntriesArrayList, "First graph")
        barData = BarData(barDataSet)
        barDataSet.valueTextColor = Color.BLUE
        barDataSet.valueTextSize = 14f
        chart?.data = barData
        home_frag_chart_ev_duration11.data = barData

        chart?.getDescription()?.setEnabled(false)
        chart?.setDrawGridBackground(false)
        chart?.setMaxVisibleValueCount(60)
        chart?.setPinchZoom(false)
        chart?.setDrawGridBackground(false)
        chart?.setDrawGridBackground(false)

        //  barDataSet?.setColors(*ColorTemplate.MATERIAL_COLORS) ->read only colors ->adding color to our bar data set.
     //   barDataSet.setColors(*ColorTemplate1.MATERIAL_COLORS1) //read and write only colors
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_detail -> {
                val intent = Intent(Intent.ACTION_VIEW).setClassName(
                    "ru.slybeaver.truecalendar", "ru.slybeaver.truecalendar.CalendarActivity"
                )
                startActivity(intent)
            }
        }
    }

    private fun getBarEntries() {
        barEntriesArrayList = ArrayList<BarEntry>()

   /*     barEntriesArrayList!!.add(BarEntry(1f, 4f))
        barEntriesArrayList!!.add(BarEntry(2f, 6f))
        barEntriesArrayList!!.add(BarEntry(3f, 5f))
        barEntriesArrayList!!.add(BarEntry(4f, 2f))
        barEntriesArrayList!!.add(BarEntry(5f, 4f))
        barEntriesArrayList!!.add(BarEntry(6f, 1f))
        barEntriesArrayList!!.add(BarEntry(7f, 3f))*/

        val pushToEntity1 = GraphEntity(1f, 4f)
        val pushToEntity2 = GraphEntity(2f, 6f)
        val pushToEntity3 = GraphEntity(3f, 5f)
        val pushToEntity4 = GraphEntity(5f, 4f)
        val pushToEntity5 = GraphEntity(6f, 1f)
        val pushToEntity6 = GraphEntity(7f, 3f)

      val temp =  CoroutineScope(Dispatchers.IO).async{
            dao.register(pushToEntity1)
            dao.register(pushToEntity2)
            dao.register(pushToEntity3)
            dao.register(pushToEntity4)
            dao.register(pushToEntity5)
            dao.register(pushToEntity6)
        }

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
    }

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(arg0: AdapterView<*>?) {
    }

}