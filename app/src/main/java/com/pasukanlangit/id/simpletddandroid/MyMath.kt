package com.pasukanlangit.id.simpletddandroid

import kotlin.math.sqrt

/***
 * this object is for math functionality
 */
object MyMath {
    fun max(n1: Int, n2: Int): Int{
        return if(n1 > n2) n1 else n2
    }

    fun isEven(number: Int): Boolean{
        return number % 2 == 0
    }

    fun isPrimeNumber(number: Int): Boolean{
        if(number < 2) return false
        for(i in 2..sqrt(number.toDouble()).toInt()){
            if(number % i == 0) return false
        }
        return true
    }
}