package lotto.model

object InputParser {

    fun parseWinningNumbers(rawWinningNumbers: String): List<String> {
        val winningNumbers = mutableListOf<String>()
        winningNumbers.addAll(rawWinningNumbers.split(","))
        return winningNumbers
    }
}
