package com.example.project

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainA : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_a, container, false)

        val manager = LinearLayoutManager(this.context)

        val list = mutableListOf<Recipe>()
        for (i in 1..5) {
            list.addAll(listOf(Recipe(R.drawable.cajun, "Cajun Chicken & Rice"),
                Recipe(R.drawable.hainanese, "Hainanese Chicken Rice"),
                Recipe(R.drawable.soup, "Chicken & Rice Soup")))
        }

        val adapter = Adapter(list)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = manager

        // TODO clickable

        return view
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textView = itemView.findViewById<TextView>(R.id.text)
    val imageView = itemView.findViewById<ImageView>(R.id.image)

    fun render(recipe: Recipe) {
        textView.text = recipe.text
        imageView.setImageResource(recipe.image)
    }
}

class Adapter(val list: List<Recipe>): RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_layout, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}


data class Recipe (
    val image: Int = 0,
    val text: String = ""
)