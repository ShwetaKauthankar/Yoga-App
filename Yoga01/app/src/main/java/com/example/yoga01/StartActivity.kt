package com.example.yoga01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class StartActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var drawerLayout:DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        var beginner:ImageView=findViewById(R.id.beginner)
        var intermediate:ImageView=findViewById(R.id.intermediate)
        var expert:ImageView=findViewById(R.id.expert)

        beginner.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra("label","Beginner")
            startActivity(intent)
        }

        intermediate.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra("label","intermediate")
            startActivity(intent)
        }

        expert.setOnClickListener {
            var intent = Intent(this,MainActivity::class.java)
            intent.putExtra("label","expert")
            startActivity(intent)
        }
        var toolbar1 :Toolbar? =findViewById<Toolbar>(R.id.toolbar1)
         drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout1)

        setSupportActionBar(toolbar1)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar1, 0, 0
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        toggle.isDrawerIndicatorEnabled = true

        val navigationView = findViewById<NavigationView>(R.id.navigationView1)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        Log.d("StartActivity","${menuItem.itemId}")
        when (menuItem.itemId) {
            R.id.rem -> {
                val intent = Intent(this, Alarm::class.java)
                startActivity(intent)
            }
            R.id.bmi -> {
                    val intent = Intent(this, BMIActivity::class.java)
                    startActivity(intent)
            }
            R.id.nutrition -> {
                val intent = Intent(this, NutritionActivity::class.java)
                startActivity(intent)
            }
            R.id.setting -> {
                val intent = Intent(this, SignoutActivity::class.java)
                startActivity(intent)
            }
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
