package com.cv.app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.cv.app.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var toolbar: ActionBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        toolbar = supportActionBar
        if (savedInstanceState == null) {
            toolbar!!.title = "Profile"
            val fragment = ProfileFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame_container, fragment, fragment.javaClass.getSimpleName())
                .commit()

        }

    }

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_profile -> {
                    toolbar!!.title = "Profile"
                    val fragment = ProfileFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_profileExtra -> {
                    toolbar!!.title = "Published App"
                    val fragment = ProfileExtraFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_socialLinks -> {
                    toolbar!!.title = "Social"
                    val fragment = SocialFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_container, fragment, fragment.javaClass.getSimpleName())
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
}
