package lotto.model

import lotto.constant.Rank
import lotto.constant.message.ErrorMessage
import kotlin.collections.set

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == numbers.toSet().size) { ErrorMessage.INVALID_WINNING_NUMBERS_DUPLICATE.formattedText() }
        require(numbers.size == 6) { ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.formattedText() }
        numbers.forEach { number ->
            require(number in 1..45) { ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.formattedText() }
        }
    }

    fun calculateWinningResults(lottos: List<List<Int>>, bonusNumber: Int): Map<String, Int> {
        val winningResults = mutableMapOf<String, Int>()
        initializeWinningResults(winningResults)
        lottos.forEach { lotto ->
            updateWinningResults(lotto, winningResults, bonusNumber)
        }
        return winningResults
    }

    fun getWinningNumbers() = numbers

    private fun initializeWinningResults(winningResults: MutableMap<String, Int>) {
        winningResults[Rank.FIRST.value] = 0
        winningResults[Rank.SECOND.value] = 0
        winningResults[Rank.THIRD.value] = 0
        winningResults[Rank.FOURTH.value] = 0
        winningResults[Rank.FIFTH.value] = 0
    }

    private fun updateWinningResults(lotto: List<Int>, winningResults: MutableMap<String, Int>, bonusNumber: Int) {
        val winningCount = lotto.count { numbers.contains(it) }
        when (winningCount) {
            6 -> winningResults[Rank.FIRST.value] = winningResults.getOrDefault(Rank.FIRST.value, 0) + 1
            5 if lotto.contains(bonusNumber) -> winningResults[Rank.SECOND.value] =
                winningResults.getOrDefault(Rank.SECOND.value, 0) + 1

            5 -> winningResults[Rank.THIRD.value] = winningResults.getOrDefault(Rank.THIRD.value, 0) + 1
            4 -> winningResults[Rank.FOURTH.value] = winningResults.getOrDefault(Rank.FOURTH.value, 0) + 1
            3 -> winningResults[Rank.FIFTH.value] = winningResults.getOrDefault(Rank.FIFTH.value, 0) + 1
        }
    }
}