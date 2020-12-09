package com.sabat.polijaz.courses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sabat.polijaz.R

class CoursesRViewAdapter(private val dataSet: Array<String>,
                        private val itemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<CoursesRViewAdapter.ViewHolder>() {

    interface OnItemClickListener {
        fun onItemClicked(course: String)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val courseView: TextView = view.findViewById(R.id.courseView)

        fun bind(courseName: String, clickListener: OnItemClickListener) {
            courseView.setOnClickListener {
                clickListener.onItemClicked(courseName)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.text_row_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val courseName = dataSet[position]

        holder.courseView.text = courseName
        holder.bind(courseName, itemClickListener)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}