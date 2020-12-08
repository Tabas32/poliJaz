package com.sabat.polijaz.courses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sabat.polijaz.R

/**
 * Fragment for displaying available courses
 */
class CoursesPageFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentView = inflater.inflate(R.layout.courses_fragment, container, false)
        val recyclerView = fragmentView.findViewById<RecyclerView>(R.id.coursesRecyclerView)

        val coursesList = arrayOf("English", "German")
        recyclerView.layoutManager = LinearLayoutManager(this.activity?.applicationContext)
        recyclerView.adapter = CoursesRViewAdapter(coursesList)

        return fragmentView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.goBack_button).setOnClickListener {
            findNavController().navigate(R.id.action_CoursePageFragment_to_FirstFragment)
        }
    }
}