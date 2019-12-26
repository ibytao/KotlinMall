package com.kotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.SimpleAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var dataList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            arrayOf("one", "two", "three", "one", "two", "three", "one", "two", "three", "one", "two", "three", "one", "two", "three"))
//        mListV.adapter = adapter

        val map = mapOf("one" to 1, "two" to 2)

        val list = listOf<Map<String, Int>>(map, map)
        val simpleAdapter = SimpleAdapter(this, list, R.layout.item_userinfo, arrayOf("one", "two"), intArrayOf(R.id.mTvname, R.id.mTvage))
//        mListV.adapter = simpleAdapter

        for (i in 0..50) {
            dataList.add("onew" + i)
        }

        mListV.adapter = UserInfoListAdapter()
    }

    inner class UserInfoListAdapter: BaseAdapter() {
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val view = LayoutInflater.from(applicationContext).inflate(R.layout.item_userinfo, null)
            val name = view.findViewById<TextView>(R.id.mTvname)
            name.text = dataList[p0]
            return view
        }

        override fun getItem(p0: Int): Any {
            return this@MainActivity.dataList[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return this@MainActivity.dataList.size
        }
    }
}
