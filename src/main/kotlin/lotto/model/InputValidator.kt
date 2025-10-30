package lotto.model

import lotto.message.ErrorMessage

object InputValidator {

    fun validateInputPrice(purchase: String) {
        val inputPurchase = purchase.toIntOrNull()
        require(inputPurchase != null) { ErrorMessage.INVALID_AMOUND_FORMAT.formattedText() }
        require(inputPurchase > 1000) { ErrorMessage.INVALID_AMOUNT_RANGE.formattedText() }
        require(inputPurchase % 1000 == 0) { ErrorMessage.INVALID_AMOUNT_UNIT.formattedText() }
    }

    fun validateInputWinningNumber(winningNumbers: List<String>) {
        val translateWinningNumbers = winningNumbers.map { it.toIntOrNull() }

        require(translateWinningNumbers.size == 6) { ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.formattedText() }
        translateWinningNumbers.forEach { number ->
            require(number != null) { ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.formattedText() }
            require(number in 1..45) { ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.formattedText() }
        }
    }
}
