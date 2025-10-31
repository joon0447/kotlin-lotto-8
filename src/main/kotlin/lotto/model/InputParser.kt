package lotto.model

import lotto.message.ErrorMessage

object InputParser {

    fun parseWinningNumbers(rawWinningNumbers: String): List<Int> {
        val winningNumbers = mutableListOf<Int>()

        winningNumbers.addAll(rawWinningNumbers.split(",").map {
            val num = it.toIntOrNull()
            require(num != null) { ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.formattedText() }
            num
        })
        return winningNumbers
    }
}
