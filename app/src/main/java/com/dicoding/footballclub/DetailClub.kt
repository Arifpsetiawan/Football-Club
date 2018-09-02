package com.dicoding.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import org.jetbrains.anko.dip
import org.jetbrains.anko.padding
import org.jetbrains.anko.textView
import org.jetbrains.anko.verticalLayout

class DetailClub : AppCompatActivity(){
    private var detail : String = ""
    private lateinit var detailTextView : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout{
            padding = dip(16)
            detailTextView = textView()
        }

        val intent = intent
        detail = intent.getStringExtra("detail")
        detailTextView.text = detail
    }
}