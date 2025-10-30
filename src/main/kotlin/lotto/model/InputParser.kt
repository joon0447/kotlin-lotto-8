package lotto.model

object InputParser {

    fun parseWinningNumbers(rawWinningNumbers: String): List<Int?> {
        val winningNumbers = mutableListOf<Int?>()
        winningNumbers.addAll(rawWinningNumbers.split(",").map{ it.toIntOrNull()})
        return winningNumbers
    }
}
