package lotto.model

import lotto.constant.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {

    @Test
    fun `수익률 계산`() {
        val total = 8000
        val winningResults = mutableMapOf<Rank, Int>()
        winningResults[Rank.FIRST] = 0
        winningResults[Rank.SECOND] = 0
        winningResults[Rank.THIRD] = 0
        winningResults[Rank.FOURTH] = 0
        winningResults[Rank.FIFTH] = 1

        assertEquals("62.5", ProfitCalculator.calculateProfit(total, winningResults))
    }
}