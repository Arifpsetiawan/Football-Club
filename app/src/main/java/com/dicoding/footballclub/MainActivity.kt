package com.dicoding.footballclub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<ClubItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        list_club.layoutManager = LinearLayoutManager(this)
        list_club.adapter = RecyclerViewAdapter(this, items){
            startActivity<DetailClub>("detail" to "${it.detail}","image" to it.image)
        }
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_image)
        val detail = resources.getStringArray(R.array.club_detail)
        items.clear()
        for (i in name.indices) {
            items.add(ClubItem(name[i],
                    image.getResourceId(i, 0),detail[i]))
        }

        //Recycle the typed array
        image.recycle()
    }

}
