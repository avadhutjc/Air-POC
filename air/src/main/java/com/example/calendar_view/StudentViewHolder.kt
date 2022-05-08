package com.example.calendar_view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var mTvName: TextView? = null
    private var mTvAge: TextView? = null
    private var mGraph: View? = null

    private fun iniViews(itemView: View) {
        mTvName = itemView.findViewById(R.id.headline)
        mTvAge = itemView.findViewById(R.id.second_practice_sessions)
        mGraph = itemView.findViewById(R.id.home_frag_chart)
    }

    fun setData(student: Student) {
        mTvName!!.text = student.name
        mTvAge!!.text = student.age.toString() + ""
    }

    init {
        iniViews(itemView)
    }
}

