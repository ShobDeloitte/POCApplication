package com.dsu.poc

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.dsu.poc.base.BaseActivity
import com.dsu.poc.project.ui.login.LoginFragment

/**
 * An activity class to control the navigation of all other classes
 */
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val host = NavHostFragment.create(R.navigation.welcome_nav)
        supportFragmentManager.beginTransaction().replace(R.id.container_basic, host).setPrimaryNavigationFragment(host).commit()
    }

    override fun onSupportNavigateUp(): Boolean = Navigation.findNavController(this, R.id.container_basic).navigateUp()
}