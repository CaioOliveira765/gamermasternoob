package com.example.gamernoob

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.gamemasternoob.Adapter.ListPlayListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val Id_Channel: String = "xlongshot187XD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycle_playlist.layoutManager = LinearLayoutManager(this)
        recycle_playlist.adapter = ListPlayListAdapter()

        buscarJson()

    }

    private fun buscarJson() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
