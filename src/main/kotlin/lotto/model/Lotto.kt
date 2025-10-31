package lotto.model

import lotto.constant.Key
import kotlin.collections.set

class Lotto(private val numbers: List<Int>) {

    var bonusNumber: Int? = null
        private set

    fun setBonusNumber(bonusNumber: Int) {
        this.bonusNumber = bonusNumber
    }

    fun calculateWinner(lottos: List<List<Int>>): Map<String, Int> {
        val winners = mutableMapOf<String, Int>()
        initializeWinnerCount(winners)
        lottos.forEach { lotto ->
            updateWinnerCount(lotto, winners)
        }
        return winners
    }

    private fun initializeWinnerCount(winners: MutableMap<String, Int>) {
        winners[Key.FIRST.value] = 0
        winners[Key.SECOND.value] = 0
        winners[Key.THIRD.value] = 0
        winners[Key.FOURTH.value] = 0
        winners[Key.FIFTH.value] = 0
    }

    private fun updateWinnerCount(lotto: List<Int>, winners: MutableMap<String, Int>) {
        val winningCount = lotto.count { numbers.contains(it) }
        when (winningCount) {
            6 -> winners[Key.FIRST.value] = winners.getOrDefault(Key.FIRST.value, 0) + 1
            5 if lotto.contains(bonusNumber) -> winners[Key.SECOND.value] =
                winners.getOrDefault(Key.SECOND.value, 0) + 1

            5 -> winners[Key.THIRD.value] = winners.getOrDefault(Key.THIRD.value, 0) + 1
            4 -> winners[Key.FOURTH.value] = winners.getOrDefault(Key.FOURTH.value, 0) + 1
            3 -> winners[Key.FIFTH.value] = winners.getOrDefault(Key.FIFTH.value, 0) + 1
        }
    }
}