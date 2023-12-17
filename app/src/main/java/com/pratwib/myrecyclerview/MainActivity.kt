package com.pratwib.myrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvFootballer: RecyclerView
    private val list = ArrayList<Footballer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionbar = supportActionBar
        actionbar!!.title = "Top 10 Footballer 2022"

        rvFootballer = findViewById(R.id.rv_footballer)
        rvFootballer.setHasFixedSize(true)

        list.addAll(getListFootballer())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_list -> {
                rvFootballer.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvFootballer.layoutManager = GridLayoutManager(this, 2)
            }
            R.id.about -> {
                val intentAbout = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intentAbout)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun getListFootballer(): ArrayList<Footballer>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataAge = resources.getStringArray(R.array.data_age)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataLink = resources.getStringArray(R.array.data_link)
        val dataPosition = resources.getStringArray(R.array.data_position)
        val listFootballers = ArrayList<Footballer>()
        for (i in dataName.indices){
            val footballer = Footballer(dataName[i], dataDescription[i], dataPhoto[i], dataAge[i], dataPrice[i], dataLink[i], dataPosition[i])
            listFootballers.add(footballer)
        }

        return listFootballers
    }

    private fun showRecyclerList(){
        rvFootballer.layoutManager = LinearLayoutManager(this)
        val listFootballerAdapter = ListFootballerAdapter(list)
        rvFootballer.adapter = listFootballerAdapter
    }
}