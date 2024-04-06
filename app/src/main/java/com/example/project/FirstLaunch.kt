package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FirstLaunch : Fragment() {
    lateinit var listener: ClickListener
    lateinit var helloScreen: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first_launch, container, false)
        listener = activity as ClickListener
        helloScreen = view.findViewById(R.id.first_launch)

        helloScreen.setOnClickListener {
            listener.goMain()
            listener.goSmallA()
        }

        return view
    }
}