package com.pasukanlangit.id.simpletddandroid

/***
 * Set rule
 * 1. unique value
 * 2. no order
 *
 * Rules:
 * 1. try to not import everything. build your own code, use primitive type
 */
class Set {
    var size = 0
        private set
    private val values = Array<Any?>(3) {}

    fun isEmpty(): Boolean = size == 0

    fun add(addedValue: Any){
        if(contains(addedValue)) return

        values[size] = addedValue
        size++
    }

    fun remove(value: Any){
        for (i in 0 until size){
            if(values[i] == value){
//                swap the latest item to removed index, so no spacing item
//                example:
//                ABCD
//                REMOVE : B
//                A_CD
//                SWAP LAST ITEM : ACD_
//                SO NO EMPTY SPACE
                values[i] = values[size-1]
                values[size-1] = null
                size--
                break
            }
        }
    }

    fun contains(value: Any): Boolean{
        for(i in 0 until size){
            if(values[i] == value) return true
        }
        return false
    }
}