package com.pasukanlangit.id.simpletddandroid


import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class SetTest {

    private lateinit var set: Set

    @Before
    fun setUp(){
        set = Set()
    }

    @Test
    fun `should return valid isEmpty`(){
        assertThat(set.isEmpty()).isEqualTo(true)

        addToSet(42, "Bali")
        assertThat(set.isEmpty()).isEqualTo(false)
    }

    @Test
    fun `should return valid size`(){
        assertThat(set.size).isEqualTo(0)
        addToSet(213, false, "Jakarta")

        assertThat(set.size).isEqualTo(3)
    }

    @Test
    fun `should contain added value`(){
        assertThat(set.contains(213)).isEqualTo(false)

        addToSet(213, "Jakarta", false)
        assertThat(set.contains(213)).isEqualTo(true)
        assertThat(set.contains("Jakarta")).isEqualTo(true)
        assertThat(set.contains(false)).isEqualTo(true)
    }

    @Test
    fun `should ignore value added when it contains in set`(){
        addToSet(213, "Malaysia", 213)

        assertThat(set.size).isEqualTo(2)
        set.add(412)
        assertThat(set.size).isEqualTo(3)
    }

    @Test
    fun `should remove value and return correct size`(){
        addToSet(22, 32, "Jakarta")
        set.remove(32)

        assertThat(set.contains(32)).isEqualTo(false)
        assertThat(set.size).isEqualTo(2)
        set.add(32)
        assertThat(set.contains(32)).isEqualTo(true)
        assertThat(set.contains(22)).isEqualTo(true)
        assertThat(set.contains("Jakarta")).isEqualTo(true)
        assertThat(set.size).isEqualTo(3)

    }

    private fun addToSet(vararg valuesAdded : Any){
        valuesAdded.forEach { value ->
            set.add(value)
        }
    }
}