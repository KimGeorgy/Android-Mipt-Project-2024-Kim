package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.textfield.TextInputLayout

class SmallB : Fragment() {
    private lateinit var listener: ClickListener
    private lateinit var buttonSearch: Button
    private lateinit var textField: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_small_b, container, false)

        listener = activity as ClickListener
        buttonSearch = view.findViewById(R.id.button_search_recipe)
        textField = view.findViewById(R.id.textField)
        if (savedInstanceState != null) {
            textField.editText?.setText(savedInstanceState.getString(TEXT_A_KEY))
        }

        buttonSearch.setOnClickListener {
            listener.searchNutrition(textField.editText?.text.toString())
        }

        return view
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(TEXT_A_KEY, textField.editText?.text.toString())
    }

    companion object {
        const val TEXT_A_KEY = "textb"
    }
}