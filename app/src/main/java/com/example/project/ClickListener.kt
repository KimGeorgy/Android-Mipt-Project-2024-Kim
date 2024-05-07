package com.example.project

interface ClickListener {
    fun goMain()
    fun goSmallA()
    fun goSmallB()
    fun searchRecipe(keywords: String)
    fun searchNutrition(keywords: String)
}