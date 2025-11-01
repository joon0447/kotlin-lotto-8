package lotto.model

import lotto.constant.Rank
import lotto.constant.message.ErrorMessage
import kotlin.collections.set

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == numbers.toSet().size) { ErrorMessage.INVALID_WINNING_NUMBERS_DUPLICATE }
        require(numbers.size == 6) { ErrorMessage.INVALID_WINNING_NUMBERS_COUNT }
        numbers.forEach { number ->
            require(number in 1..45) { ErrorMessage.INVALID_WINNING_NUMBERS_RANGE }
        }
    }

    fun calculateWinningResults(lottos: List<List<Int>>, bonusNumber: Int): Map<Rank, Int> {
        val winningResults = mutableMapOf<Rank, Int>()
        initializeWinningResults(winningResults)
        lottos.forEach { lotto ->
            updateWinningResults(lotto, winningResults, bonusNumber)
        }
        return winningResults.toSortedMap(compareByDescending { it.rank })
    }

    fun getWinningNumbers() = numbers

    private fun initializeWinningResults(winningResults: MutableMap<Rank, Int>) {
        winningResults[Rank.FIRST] = 0
        winningResults[Rank.SECOND] = 0
        winningResults[Rank.THIRD] = 0
        winningResults[Rank.FOURTH] = 0
        winningResults[Rank.FIFTH] = 0
    }

    private fun updateWinningResults(lotto: List<Int>, winningResults: MutableMap<Rank, Int>, bonusNumber: Int) {
        val winningCount = lotto.count { numbers.contains(it) }
        when (winningCount) {
            6 -> winningResults[Rank.FIRST] = winningResults.getOrDefault(Rank.FIRST, 0) + 1
            5 if lotto.contains(bonusNumber) -> winningResults[Rank.SECOND] =
                winningResults.getOrDefault(Rank.SECOND, 0) + 1

            5 -> winningResults[Rank.THIRD] = winningResults.getOrDefault(Rank.THIRD, 0) + 1
            4 -> winningResults[Rank.FOURTH] = winningResults.getOrDefault(Rank.FOURTH, 0) + 1
            3 -> winningResults[Rank.FIFTH] = winningResults.getOrDefault(Rank.FIFTH, 0) + 1
        }
    }
}