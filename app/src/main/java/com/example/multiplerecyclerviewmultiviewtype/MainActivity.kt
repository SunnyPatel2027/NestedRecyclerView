package com.example.multiplerecyclerviewmultiviewtype

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiplerecyclerviewmultiviewtype.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mList: ArrayList<DataItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.mainRecyclerView.setHasFixedSize(true)
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)

        mList = ArrayList()
        prepareData()

        val adapter = MainAdapter(mList)
        binding.mainRecyclerView.adapter = adapter
    }

    private fun prepareData() {

        // best seller
        val recordList = ArrayList<RecyclerItem1>()
        recordList.add(RecyclerItem1("2 Days" , "4 Lesson", "8 Challenges"))
        recordList.add(RecyclerItem1("3 Days" , "7 Lesson", "11 Challenges"))

        //clothing
        val webCardList = ArrayList<RecyclerItem2>()
        webCardList.add(RecyclerItem2(R.drawable.levis_clothing, "Online Learning Platforms &amp; Their Features", " June 12th 2023 • 09:00 AM"))
        webCardList.add(RecyclerItem2(R.drawable.women_clothing, "Online Learning Platforms &amp; Their Features", " June 12th 2023 • 09:00 AM"))
        webCardList.add(RecyclerItem2(R.drawable.nikeshoes, "Online Learning Platforms &amp; Their Features", " June 12th 2023 • 09:00 AM"))
        webCardList.add(RecyclerItem2(R.drawable.levis_clothing, "Online Learning Platforms &amp; Their Features", " June 12th 2023 • 09:00 AM"))
        webCardList.add(RecyclerItem2(R.drawable.women_clothing, "Online Learning Platforms &amp; Their Features", " June 12th 2023 • 09:00 AM"))
        webCardList.add(RecyclerItem2(R.drawable.nikeshoes, "Online Learning Platforms &amp; Their Features", " June 12th 2023 • 09:00 AM"))

        mList.add(DataItem.createWithBanner(DataItemType.BANNER, Banner(R.drawable.tv_offer)))
        mList.add(DataItem.createWithDataItemList1(DataItemType.RECORD_CARD, recordList))
        mList.add(DataItem.createWithDataItemList2(DataItemType.WEB_CARD, webCardList))
    }
}