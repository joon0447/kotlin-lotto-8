package lotto.model

import lotto.constant.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {

    @Test
    fun `수익률 계산`() {
        val total = 8000
        val winningResults = mutableMapOf<String, Int>()
        winningResults[Rank.FIRST.value] = 0
        winningResults[Rank.SECOND.value] = 0
        winningResults[Rank.THIRD.value] = 0
        winningResults[Rank.FOURTH.value] = 0
        winningResults[Rank.FIFTH.value] = 1

        assertEquals("62.5", ProfitCalculator.calculateProfit(total, winningResults))
    }
}