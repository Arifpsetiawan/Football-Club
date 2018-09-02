package com.dicoding.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailClub : AppCompatActivity(){
    private var detail : String = ""
    private lateinit var detailTextView : TextView
    private lateinit var detailImageView : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        verticalLayout{
            padding = dip(16)
            detailImageView = imageView{}.lparams{
                width = dip(75)
                height = dip(75)
                gravity = Gravity.CENTER_HORIZONTAL
            }
            detailTextView = textView()
        }

        val intent = intent
        detail = intent.getStringExtra("detail")
        val image = intent.getIntExtra("image",0)
        Glide.with(this).load(image).into(detailImageView)
        detailTextView.text = detail
    }
}