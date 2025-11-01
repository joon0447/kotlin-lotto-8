package lotto.model

import lotto.constant.message.ErrorMessage

object InputValidator {

    fun validateInputPrice(purchase: String) {
        val inputPurchase = purchase.toIntOrNull()
        require(inputPurchase != null) { ErrorMessage.INVALID_AMOUND_FORMAT.formattedText() }
        require(inputPurchase >= 1000) { ErrorMessage.INVALID_AMOUNT_RANGE.formattedText() }
        require(inputPurchase % 1000 == 0) { ErrorMessage.INVALID_AMOUNT_UNIT.formattedText() }
    }

    fun validateInputBonusNumber(number: String, winningNumbers: List<Int>) {
        val bonusNumber = number.toIntOrNull()
        require(!winningNumbers.contains(bonusNumber)) { ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE.formattedText() }
        require(bonusNumber != null) { ErrorMessage.INVALID_BONUS_NUMBER_FORMAT.formattedText() }
        require(bonusNumber in 1..45) { ErrorMessage.INVALID_BONUS_NUMBER_RANGE.formattedText() }
    }
}
