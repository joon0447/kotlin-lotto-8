package lotto.model

import lotto.constant.LottoRule
import lotto.constant.Rank
import lotto.constant.message.ErrorMessage
import kotlin.collections.set

class Lotto(private val numbers: List<Int>) {
    init {
        val numberRange = LottoRule.MIN_WINNING_NUMBER..LottoRule.MAX_WINNING_NUMBER
        require(numbers.size == numbers.toSet().size) { ErrorMessage.INVALID_WINNING_NUMBERS_DUPLICATE }
        require(numbers.size == LottoRule.WINNING_NUMBERS_SIZE) { ErrorMessage.INVALID_WINNING_NUMBERS_COUNT }
        require(numbers.all { it in numberRange}) { ErrorMessage.INVALID_WINNING_NUMBERS_RANGE }
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
        Rank.entries.forEach { winningResults[it] = 0 }
    }

    private fun updateWinningResults(lotto: List<Int>, winningResults: MutableMap<Rank, Int>, bonusNumber: Int) {
        val matchCount = lotto.count { numbers.contains(it) }
        when (matchCount) {
            Rank.FIRST.match -> winningResults[Rank.FIRST] = winningResults.getOrDefault(Rank.FIRST, 0) + 1
            Rank.SECOND.match if lotto.contains(bonusNumber) -> winningResults[Rank.SECOND] =
                winningResults.getOrDefault(Rank.SECOND, 0) + 1

            Rank.THIRD.match -> winningResults[Rank.THIRD] = winningResults.getOrDefault(Rank.THIRD, 0) + 1
            Rank.FOURTH.match -> winningResults[Rank.FOURTH] = winningResults.getOrDefault(Rank.FOURTH, 0) + 1
            Rank.FIFTH.match -> winningResults[Rank.FIFTH] = winningResults.getOrDefault(Rank.FIFTH, 0) + 1
        }
    }
}
