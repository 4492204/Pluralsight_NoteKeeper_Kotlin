package com.example.nootkeeper_kotlin

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import android.widget.TextView
import androidx.preference.PreferenceManager.getDefaultSharedPreferences
import kotlinx.android.synthetic.main.content_items.*
import kotlinx.android.synthetic.main.nav_header_items.*

class ItemsActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { _ ->
            val activityIntent = Intent(this, NoteActivity::class.java)
            startActivity(activityIntent)
        }
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        listItems.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        listItems.adapter = NoteRecyclerAdapter(this, DataManager.notes)

        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        updateDrawer()
    }

    private fun updateDrawer() {
        val sharedPreferences = getDefaultSharedPreferences(applicationContext)
        val userName = sharedPreferences.getString("username", KEY_DEFAULT_USER_NAME)
        val userEmail = sharedPreferences.getString("userEmail", KEY_DEFAULT_USER_EMAIL)
        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        val header = navigationView.getHeaderView(0)
        header.findViewById<TextView>(R.id.textUserName).apply{
            text = userName
        }
        header.findViewById<TextView>(R.id.textUserEmail).apply{
            text = userEmail
        }

    }


    override fun onResume() {
        super.onResume()
        listItems.adapter?.notifyDataSetChanged()
        updateDrawer()
    }

    override fun onBackPressed() {
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.items, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {
                startActivity(Intent(this, MySettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                startActivity(Intent(this, ItemsActivity::class.java))
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
