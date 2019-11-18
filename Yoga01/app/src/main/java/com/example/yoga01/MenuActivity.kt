package com.example.yoga01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, 0, 0
        )
        toggle.syncState()
        toggle.isDrawerIndicatorEnabled = true
        val navigationView = findViewById<NavigationView>(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.rem -> {
                Toast.makeText(this, "Publication", Toast.LENGTH_SHORT).show()
            }
            R.id.todo -> {
                Toast.makeText(this, "Android Store", Toast.LENGTH_SHORT).show()
            }
            R.id.nutrition -> {
                Toast.makeText(this, "Newsletter", Toast.LENGTH_SHORT).show()
            }

        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

}
