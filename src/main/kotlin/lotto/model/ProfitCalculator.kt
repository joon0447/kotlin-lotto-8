package lotto.model

import lotto.constant.Rank

object ProfitCalculator {
    fun calculateProfit(buyMoney: Int, winningResults: Map<Rank, Int>): String {
        val totalPrizeMoney = winningResults.entries.sumOf{(rank, count) ->
            rank.prizeMoney * count
        }

        return String.format("%.1f", (totalPrizeMoney / buyMoney.toDouble()) * 100)
    }
}