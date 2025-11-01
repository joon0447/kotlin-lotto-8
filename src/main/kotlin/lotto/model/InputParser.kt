package lotto.model

import lotto.constant.message.ErrorMessage

object InputParser {

    fun parseWinningNumbers(rawWinningNumbers: String): List<Int> {
        val winningNumbers = mutableListOf<Int>()
        rawWinningNumbers.split(",").forEach { value ->
            val num = value.toIntOrNull()
            require(num != null) { ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.formattedText() }
            winningNumbers.add(num)
        }
        return winningNumbers
    }
}
