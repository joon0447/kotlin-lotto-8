package lotto.model

import lotto.constant.Key
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {

    @Test
    fun `수익률 계산`() {
        val total = 8000
        val winningResults = mutableMapOf<String, Int>()
        winningResults[Key.FIRST.value] = 0
        winningResults[Key.SECOND.value] = 0
        winningResults[Key.THIRD.value] = 0
        winningResults[Key.FOURTH.value] = 0
        winningResults[Key.FIFTH.value] = 1

        assertEquals("62.5", ProfitCalculator.calculateProfit(total, winningResults))
    }
}