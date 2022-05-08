package com.example.calendar_view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(var studentList: ArrayList<Student>) : RecyclerView.Adapter<StudentViewHolder>() {
   /* private var studentList = arrayListOf<Student>()

    fun StudentAdapter(studentList: ArrayList<Student>?) {
        if (studentList != null) {
            this.studentList = studentList
        }
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.graph_item_layout, parent, false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = studentList.get(position)
        holder.setData(student)
    }

    override fun getItemCount(): Int {
        return  studentList.size;
    }
}

