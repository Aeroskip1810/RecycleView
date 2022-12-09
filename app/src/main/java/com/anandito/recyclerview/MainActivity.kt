package com.anandito.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvTortos: RecyclerView
    val list = ArrayList<Torto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvTortos = findViewById(R.id.rvTorto)
        rvTortos.setHasFixedSize(true)

        list.addAll(listTortos)
        showRecycleView()

    }

    private val listTortos: ArrayList<Torto>
            get() {
                val dataName = resources.getStringArray(R.array.data_name)
                val dataDescription = resources.getStringArray(R.array.data_description)
                val dataPhoto = resources.obtainTypedArray(R.array.data_photo)

                val lists = ArrayList<Torto>()
                for (i in dataName.indices) {
                    val torto = Torto(
                        dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1)
                    )
                    lists.add(torto)

            }
                return lists
    }
    private fun showRecycleView(){
        rvTortos.layoutManager = LinearLayoutManager(this)
        val tortoListAdapter = TortoListAdapter(list)
        rvTortos.adapter = tortoListAdapter
    }
}