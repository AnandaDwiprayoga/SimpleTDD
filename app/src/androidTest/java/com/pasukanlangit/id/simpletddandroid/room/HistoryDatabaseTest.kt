package com.pasukanlangit.id.simpletddandroid.room

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asExecutor
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class HistoryDatabaseTest {

    private lateinit var db: HistoryDatabase
    private lateinit var dbDao: HistoryDao


    private val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        //because for testing purpose we created temporary database, not actual one
        db = Room
            .inMemoryDatabaseBuilder(context, HistoryDatabase::class.java)
            .setTransactionExecutor(testDispatcher.asExecutor())
            .setQueryExecutor(testDispatcher.asExecutor())
            .build()
        dbDao = db.historyDao()
    }

    @After
    fun tearDown() {
        db.close()
    }

    @Test
    fun isInsertHistorySuccess() = runBlocking {
        val history = History(
            id = 2,
            number1 = 20,
            number2 = 12,
            result = 32,
            operation = "Plus"
        )

        val history1 = History(
            id = 3,
            number1 = 20,
            number2 = 12,
            result = 8,
            operation = "Minus"
        )
        dbDao.insertHistory(history)
        dbDao.insertHistory(history1)
        val savedHistory = dbDao.getAllHistory().last()

        assertThat(savedHistory.size).isEqualTo(2)
        assertThat(savedHistory.first().operation).isEqualTo(history.operation)
        assertThat(savedHistory.last().result).isEqualTo(history1.result)
    }
}