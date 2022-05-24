package com.pasukanlangit.id.simpletddandroid

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MyMathTest {

    @Test
    fun `should return max number between 2 given parameters`(){
        val number1 = 20
        val number2 = 10
        val result = MyMath.max(n1 = number1, n2 = number2)

        assertThat(result).isEqualTo(number1)
    }

    @Test
    fun `should return max number between 2 negative given parameters`(){
        val number1 = -20
        val number2 = -10
        val result = MyMath.max(n1 = number1, n2 = number2)

        assertThat(result).isEqualTo(number2)
    }


    @Test
    fun `should return valid max number when input parameter is same`(){
        val number = -20
        val result = MyMath.max(n1 = number, n2 = number)

        assertThat(result).isEqualTo(number)
    }

    @Test
    fun`should return false when given parameter is odd`(){
        val givenInput = 13
        val result = MyMath.isEven(number = givenInput)

        assertThat(result).isEqualTo(false)
    }

    @Test
    fun`should return true when given parameter is even`(){
        val givenInput = 14
        val result = MyMath.isEven(number = givenInput)

        assertThat(result).isEqualTo(true)
    }

    @Test
    fun`should return true when given parameter is prime number`(){
        val givenInput = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97)
        val result = givenInput.all {
            MyMath.isPrimeNumber(it)
        }

        assertThat(result).isEqualTo(true)
    }


    @Test
    fun`should return false when given parameter is not prime number`(){
        val givenInput = listOf(4, 6, 8, 10, 12, 14, 15, 16, 18, 20, 22, 24, 26, 28, 30, 32)
        val result = givenInput.all {
            MyMath.isPrimeNumber(it)
        }

        assertThat(result).isEqualTo(false)
    }


    @Test
    fun`should return false when given parameter is not prime number and less than 2 `(){
        val givenInput = -1
        val result = MyMath.isPrimeNumber(givenInput)

        assertThat(result).isEqualTo(false)
    }
}