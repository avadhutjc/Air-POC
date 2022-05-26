package com.example.calendar_view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageButton
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
import kotlinx.android.synthetic.main.fragment_mid_wife.*
import kotlinx.android.synthetic.main.fragment_mid_wife.home_frag_chart_ev_duration11
import kotlinx.android.synthetic.main.fragment_mid_wife.home_frag_chart_ev_duration2
import kotlinx.android.synthetic.main.fragment_mid_wife_ev_duration.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MidWifeEvDurationFragment : Fragment(R.layout.fragment_mid_wife_ev_duration), View.OnClickListener,
    AdapterView.OnItemSelectedListener {

    var imageButton: ImageButton? = null
    var imageButton1: ImageButton? = null
    var cardView: CardView? = null
    lateinit var dao: GraphDAO
    private lateinit var database: GraphDatabase

    // variable for our bar chart
    private var barChart: BarChart? = null

    // variable for our bar data.
    private var barData: BarData? = null

    // variable for our bar data set.
    var barDataSet: BarDataSet? = null

    // array list for storing entries.
    private var barEntriesArrayList: ArrayList<BarEntry>? = null

    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = GraphDatabase.getGraphDatabase(requireContext())
        dao = database.getGraphDAO()

        navController = Navigation.findNavController(view)

        imageButton = view.findViewById<ImageButton>(R.id.btn_clear_midwife_ev_duration)
        imageButton?.setOnClickListener {
            navController.navigate(R.id.action_midWifeEvDurationFragment_to_midWifeFragment)
        }

        barChart = view.findViewById(R.id.home_frag_chart_home_evduration) //-> show correct initialization
        getBarEntries()
        barDataSet = BarDataSet(barEntriesArrayList, "First graph")
        barData = BarData(barDataSet)
        barChart?.data = barData


        //  barDataSet?.setColors(*ColorTemplate.MATERIAL_COLORS) ->read only colors ->adding color to our bar data set.
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
        barEntriesArrayList = ArrayList<BarEntry>()
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

    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {

    }

    override fun onNothingSelected(arg0: AdapterView<*>?) {
    }

}