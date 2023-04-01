package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()


        val textView: TextView = findViewById(R.id.text_view)
        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)

        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val adapter = ImageAdapter(this)
        viewPager.adapter = adapter


        button1.setOnClickListener {
            textView.text = "學號:410715669"
        }

        button2.setOnClickListener {
            textView.text = "姓名:賴威銡"
        }

    }
}


class ImageAdapter(private val context: Context) : PagerAdapter() {
    private val images = arrayOf(R.drawable.an01, R.drawable.an02, R.drawable.an03)

    override fun getCount(): Int = images.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val imageView = ImageView(context)
        imageView.setImageResource(images[position])
        container.addView(imageView)
        return imageView
    }


    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}
