package com.example.app2

import com.example.app2.services.Calculate
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun it_should_add_2_and_2_and_return_4() {
        val calc = Calculate()
        val result = calc.add(2,2)
        assertEquals(4,result)
    }

    @Test
    fun it_should_add_minus2_and_2_and_result_0() {
        val calc = Calculate()
        val result = calc.add(-2,2)
        assertEquals(0,result)
    }
}