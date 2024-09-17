package com.s9dp.study.kotlin.st_5_coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main() {

    CoroutineScope(Dispatchers.IO).launch {

        

    }

}


suspend fun getUserList(userID: Int): String {
    delay(1000)
    return "User $userID"
}






