package com.example.multiplerecyclerviewmultiviewtype

//data class DataItem(val viewType: Int) {
//
//    var recyclerItemList1: List<RecyclerItem1>? = null
//    var recyclerItemList2: List<RecyclerItem2>? = null
//    var banner: Banner? = null
//
//    constructor(viewType: Int, recyclerItemList1: List<RecyclerItem1>?) : this(viewType) {
//        this.recyclerItemList1 = recyclerItemList1
//    }
//
//    constructor(viewType: Int, recyclerItemList2: List<RecyclerItem2>?) : this(viewType) {
//        this.recyclerItemList2 = recyclerItemList2
//    }
//
//    constructor(viewType: Int, banner: Banner?) : this(viewType) {
//        this.banner = banner
//    }
//
//}

data class DataItem(val viewType: Int) {
    var recyclerItemList1: List<RecyclerItem1>? = null
    var recyclerItemList2: List<RecyclerItem2>? = null
    var banner: Banner? = null

    companion object {
        fun createWithDataItemList1(viewType: Int, recyclerItemList1: List<RecyclerItem1>): DataItem {
            val dataItem = DataItem(viewType)
            dataItem.recyclerItemList1 = recyclerItemList1
            return dataItem
        }

        fun createWithDataItemList2(viewType: Int, recyclerItemList2: List<RecyclerItem2>): DataItem {
            val dataItem = DataItem(viewType)
            dataItem.recyclerItemList2 = recyclerItemList2
            return dataItem
        }

        fun createWithBanner(viewType: Int, banner: Banner): DataItem {
            val dataItem = DataItem(viewType)
            dataItem.banner = banner
            return dataItem
        }
    }
}



data class RecyclerItem1( val days: String , val lesson : String , val challenges:String)
data class RecyclerItem2(val image: Int, val title: String, val time : String)
data class Banner(val image: Int?)