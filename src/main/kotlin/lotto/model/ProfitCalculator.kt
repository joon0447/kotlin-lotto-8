package lotto.model

import lotto.constant.Key

object ProfitCalculator {
    private const val FIRST_PRIZE_MONEY = 2000000000
    private const val SECOND_PRIZE_MONEY = 30000000
    private const val THIRD_PRIZE_MONEY = 1500000
    private const val FOURTH_PRIZE_MONEY = 50000
    private const val FIFTH_PRIZE_MONEY = 5000

    fun calculateProfit(buyMoney: Int, winningResults: Map<String, Int>): String {
        val prizeMoney = mutableMapOf<String, Int>()
        initializePrizeMoney(prizeMoney)

        var totalPrizeMoney = 0
        for (key in winningResults.keys) {
            if (winningResults.getOrDefault(key, 0) > 0) {
                totalPrizeMoney += prizeMoney.getOrDefault(key, 0)
            }
        }

        return String.format("%.1f", (totalPrizeMoney / buyMoney.toDouble()) * 100)
    }

    private fun initializePrizeMoney(prizeMoney: MutableMap<String, Int>) {
        prizeMoney[Key.FIRST.value] = FIRST_PRIZE_MONEY
        prizeMoney[Key.SECOND.value] = SECOND_PRIZE_MONEY
        prizeMoney[Key.THIRD.value] = THIRD_PRIZE_MONEY
        prizeMoney[Key.FOURTH.value] = FOURTH_PRIZE_MONEY
        prizeMoney[Key.FIFTH.value] = FIFTH_PRIZE_MONEY
    }
}