package com.example.qminsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qminsample.home.fragment.HomePageFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchUI()
    }

    private fun launchUI() {
        supportFragmentManager.beginTransaction().add(R.id.frame_layout, HomePageFragment()).commit()
    }

}