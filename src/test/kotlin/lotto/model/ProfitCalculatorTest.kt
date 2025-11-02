package lotto.model

import lotto.constant.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProfitCalculatorTest {

    @Test
    fun `8000원 구매하여 5등 1장 당첨 시 수익률이 62_5가 계산된다`() {
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