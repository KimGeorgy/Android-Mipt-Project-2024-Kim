package com.example.project

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), ClickListener {
    lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = getSharedPreferences("com.example.project", MODE_PRIVATE);

        if (savedInstanceState == null) {
            goMain()
            if (prefs.getBoolean("firstlaunch", true)) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.main_fragment_container, FirstLaunch())
                    .commitNow()
                prefs.edit().putBoolean("firstlaunch", false).apply()

            } else {
                goSmallA()
            }
        }
    }

    override fun goMain() {
        supportFragmentManager.beginTransaction()
        .replace(R.id.main_fragment_container, Main())
            .commitNow()
    }

    override fun goSmallA() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.small_fragment_container, SmallA())
            .commit()
    }

    override fun goSmallB() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.small_fragment_container, SmallB())
            .commitNow()
    }

    override fun searchRecipe(keywords: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, MainA())
            .addToBackStack(null)
            .commit()
        // TODO keywords
    }

    override fun searchNutrition(keywords: String) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, MainB())
            .addToBackStack(null)
            .commit()
        // TODO keywords
    }

    companion object {
        const val MAIN_SMALL_A = 0
        const val MAIN_SMALL_B = 1
        const val MAIN_A = 2
        const val MAIN_B = 3
        const val SCREEN_STATE_KEY = "state"
    }
}