package com.s9dp.study._13_multiple_type_rcv

sealed class ListItems {
    data class Header(val title : String) : ListItems()
    data class ImageItems(val imageRes  : Int) : ListItems()
    data class TextItem(val txt : String) : ListItems()
}