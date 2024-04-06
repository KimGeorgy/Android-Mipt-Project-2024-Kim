package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView

class Main : Fragment() {
    private lateinit var listener: ClickListener
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        bottomNavigation = view.findViewById(R.id.bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.left -> {
                    listener = activity as ClickListener
                    listener.goSmallA()
                    true
                }
                R.id.right -> {
                    listener = activity as ClickListener
                    listener.goSmallB()
                    true
                }
                else -> false
            }
        }

        return view
    }
}