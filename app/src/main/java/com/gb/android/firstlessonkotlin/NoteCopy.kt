package com.gb.android.firstlessonkotlin

class NoteCopy(val text: String, val page: Int, var someText: String = "editText") {

    fun copy(text: String = this.text, page: Int = this.page, someText: String = this.someText) = NoteCopy(text, page, someText)
}