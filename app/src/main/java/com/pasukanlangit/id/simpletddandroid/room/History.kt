package com.pasukanlangit.id.simpletddandroid.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historyTable")
data class History(
    @PrimaryKey
    val id: Long = System.currentTimeMillis(),
    val number1: Int,
    val number2: Int,
    val result: Int,
    val operation: String
)
