package lotto.model

import lotto.message.ErrorMessage

object InputValidator {

    fun validateInputPrice(purchase: String) {
        val inputPurchase = purchase.toIntOrNull()
        require(inputPurchase != null) { ErrorMessage.INVALID_AMOUND_FORMAT.formattedText() }
        require(inputPurchase > 1000) { ErrorMessage.INVALID_AMOUNT_RANGE.formattedText() }
        require(inputPurchase % 1000 == 0) { ErrorMessage.INVALID_AMOUNT_UNIT.formattedText() }
    }

    fun validateInputWinningNumber(winningNumbers: List<Int>) {
        require(winningNumbers.size == winningNumbers.toSet().size) { ErrorMessage.INVALID_WINNING_NUMBERS_DUPLICATE.formattedText() }
        require(winningNumbers.size == 6) { ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.formattedText() }
        winningNumbers.forEach { number ->
            require(number in 1..45) { ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.formattedText() }
        }
    }

    fun validateInputBonusNumber(number: String) {
        val bonusNumber = number.toIntOrNull()
        require(bonusNumber != null) { ErrorMessage.INVALID_BONUS_NUMBER_FORMAT.formattedText() }
        require(bonusNumber in 1..45) { ErrorMessage.INVALID_BONUS_NUMBER_RANGE.formattedText() }
    }
}
