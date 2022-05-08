package com.example.calendar_view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar_view.graphview.ColorTemplate1
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener,
    AdapterView.OnItemSelectedListener {

    var imageButton: ImageButton? = null
    var cardView: CardView? = null
    var cardView1: CardView? = null

    private var arrayAdapter: ArrayAdapter<String>? = null

    private var recyclerView: RecyclerView? = null

    //   private val studentList = mutableListOf<Student>()
    private val studentList = arrayListOf<Student>()

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
        initListeners()

        navController = Navigation.findNavController(view)
        // spinner = findViewById(R.id.spinners_show)

        arrayAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, itemList)
        spinners_show?.adapter = arrayAdapter
        spinners_show?.onItemSelectedListener = this

        // Drop down layout style - we get space between to list
        arrayAdapter!!.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


        /*  spinners_show.onItemSelectedListener.run {
              val intent = Intent(Intent.ACTION_VIEW).setClassName(
                  "ru.slybeaver.truecalendar", "ru.slybeaver.truecalendar.CalendarActivity"
              )
              startActivity(intent)
          }*/

        spinners_show.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                i: Int,
                l: Long
            ) {
                val items: String = adapterView?.getItemAtPosition(i) as String
                //Toast.makeText(requireContext(), items, Toast.LENGTH_LONG).show() ->will show just toast
                Toast.makeText(requireContext(), "Selected: $items", Toast.LENGTH_LONG).show() //show toast + msg

                val intent: Intent
                when (i) {
                    1 -> {
                        intent = Intent(requireContext(), SpinnerDoing::class.java)
                        startActivity(intent)
                    }

                    2 -> {
                        intent = Intent(Intent.ACTION_VIEW).setClassName(
                            "ru.slybeaver.truecalendar",
                            "ru.slybeaver.truecalendar.CalendarActivity"
                        )
                        startActivity(intent)
                    }
                    3 -> {
                        intent = Intent(requireContext(), SpinnerDoing::class.java)
                        startActivity(intent)
                    }
                    4 -> {
                        intent = Intent(Intent.ACTION_VIEW).setClassName(
                            "ru.slybeaver.truecalendar",
                            "ru.slybeaver.truecalendar.CalendarActivity"
                        )
                        startActivity(intent)
                    }
                    5 -> {
                        intent = Intent(Intent.ACTION_VIEW).setClassName(
                            "ru.slybeaver.truecalendar",
                            "ru.slybeaver.truecalendar.CalendarActivity"
                        )
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
            navController.navigate(R.id.action_homeFragment_to_birthAttendantFragment) // -> onclick of btn will open any fragment assign
        }

        cardView = view.findViewById<View>(R.id.card_view_avg_ev_duration) as CardView
        cardView?.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_birthAttendantFragment) // -> onclick of btn will open any fragment assign
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
            dialog.getWindow()?.setLayout(1300, 1400); //Controlling width and height.
            dialog.show()

            val declineButton = dialog.findViewById<View>(R.id.btn_manage_user) as TextView
            declineButton.setOnClickListener {
                navController.navigate(R.id.action_homeFragment_to_manageUserFragment) // -> onclick of btn will open any fragment assign
                dialog.dismiss()
            }

            val relativeLayout1 = dialog.findViewById<View>(R.id.rel111) as RelativeLayout
            relativeLayout1.setOnClickListener {
                navController.navigate(R.id.action_homeFragment_to_birthAttendantFragment) // -> onclick of btn will open any fragment assign
                dialog.dismiss()
            }

            val relativeLayout2 = dialog.findViewById<View>(R.id.rel11) as RelativeLayout
            relativeLayout2.setOnClickListener {
                navController.navigate(R.id.action_homeFragment_to_medicalOfficerFragment) // -> onclick of btn will open any fragment assign
                dialog.dismiss()
            }

            val relativeLayout3 = dialog.findViewById<View>(R.id.rel1) as RelativeLayout
            relativeLayout3.setOnClickListener {
                navController.navigate(R.id.action_homeFragment_to_midWifeFragment)
                dialog.dismiss()
            }

        }


/*
//        button = view.findViewById<Button>(R.id.btn_manage_user)
//        button?.setOnClickListener {
//            val dialog = Dialog(this.requireContext())
//            // Include dialog.xml file
//            dialog.setContentView(R.layout.dialog)
//            Log.d("image_set","abc")
//            navController.navigate(R.id.action_homeFragment_to_windowFragment) // -> onclick of btn will open any fragment assign
//        }

        //    button = view.findViewById<View>(R.id.btn_manage_user) as Button

//        imageButton!!.setOnClickListener {
//           // startActivity(Intent(activity, MainActivity2::class.java)) -> onclick of btn will open any activity assign
//            navController.navigate(R.id.action_homeFragment_to_windowFragment) // -> onclick of btn will open any fragment assign
//        }
//        imageButton!!.setOnClickListener {
//            val intent = Intent(this@HomeFragment, CreatorCreatePostActivity::class.java)
//            startActivity(intent)
//        }
*/

        Log.d("check", "AnotherBarActivity is running")
        //    barChart = view.findViewById<BarChart>(R.id.chart_in_home_frag) -> show wrong initialization
        barChart = view.findViewById(R.id.home_frag_chart) //-> show correct initialization
        barChart1 =
            view.findViewById(R.id.home_frag_chart_ev_duration) //-> show correct initialization
        barChart2 = view.findViewById(R.id.home_frag_chart_first_ev_duration)
        getBarEntries()
        barDataSet = BarDataSet(barEntriesArrayList, "")
        barData = BarData(barDataSet)
        barChart?.data = barData
        barChart1?.data = barData
        barChart2?.data = barData
        // adding color to our bar data set.
        //  barDataSet?.setColors(*ColorTemplate.MATERIAL_COLORS) ->read only colors
        barDataSet?.setColors(*ColorTemplate1.MATERIAL_COLORS1) //read and write only colors

        initViews()
        buildStudentList()
//        setRecyclerView()
    }

    private fun setRecyclerView() {
        val studentAdapter = StudentAdapter(studentList)
        val linearLayoutManager = LinearLayoutManager(requireContext())
//        recyclerView!!.layoutManager = linearLayoutManager
        //      recyclerView!!.adapter = studentAdapter


        Log.d("StudentList", studentList?.size.toString())
    }

    private fun buildStudentList() {
        val student1 = Student("Practice Session", 22, "11f")
        studentList.add(student1)
    }

    private fun initViews() {
        //   recyclerView = view?.findViewById<RecyclerView>(R.id.recycler_view_home_frag)
    }

    private fun initListeners() {
        btn_detail.setOnClickListener(this)
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

//            R.id.btn_manage_user -> {
//                navController.navigate(R.id.action_homeFragment_to_manageUserFragment)
//            }
//            R.id.switch_img_btn -> {
//                startActivity(Intent(activity, MainActivity2::class.java))
//            }
        }
    }

//    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        val items: String = parent?.getItemAtPosition(position) as String
//        Toast.makeText(requireContext(), items, Toast.LENGTH_LONG).show()
//
//    }
//
//    override fun onNothingSelected(parent: AdapterView<*>?) {
//        Toast.makeText(requireContext(), "Nothing Select", Toast.LENGTH_SHORT).show()
//
//    }

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