package lotto.model

import lotto.constant.Key
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

    var bonusNumber: Int? = null
        private set

    fun setBonusNumber(bonusNumber: Int) {
        this.bonusNumber = bonusNumber
    }

    fun calculateWinningResults(lottos: List<List<Int>>): Map<String, Int> {
        val winningResults = mutableMapOf<String, Int>()
        initializeWinningResults(winningResults)
        lottos.forEach { lotto ->
            updateWinningResults(lotto, winningResults)
        }
        return winningResults
    }

    private fun initializeWinningResults(winningResults: MutableMap<String, Int>) {
        winningResults[Key.FIRST.value] = 0
        winningResults[Key.SECOND.value] = 0
        winningResults[Key.THIRD.value] = 0
        winningResults[Key.FOURTH.value] = 0
        winningResults[Key.FIFTH.value] = 0
    }

    private fun updateWinningResults(lotto: List<Int>, winningResults: MutableMap<String, Int>) {
        val winningCount = lotto.count { numbers.contains(it) }
        when (winningCount) {
            6 -> winningResults[Key.FIRST.value] = winningResults.getOrDefault(Key.FIRST.value, 0) + 1
            5 if lotto.contains(bonusNumber) -> winningResults[Key.SECOND.value] =
                winningResults.getOrDefault(Key.SECOND.value, 0) + 1

            5 -> winningResults[Key.THIRD.value] = winningResults.getOrDefault(Key.THIRD.value, 0) + 1
            4 -> winningResults[Key.FOURTH.value] = winningResults.getOrDefault(Key.FOURTH.value, 0) + 1
            3 -> winningResults[Key.FIFTH.value] = winningResults.getOrDefault(Key.FIFTH.value, 0) + 1
        }
    }
}