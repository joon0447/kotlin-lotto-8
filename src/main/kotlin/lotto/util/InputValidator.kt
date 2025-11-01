package lotto.util

import lotto.constant.message.ErrorMessage

object InputValidator {

    fun validateInputPrice(purchase: String) {
        val inputPurchase = purchase.toIntOrNull()
        require(inputPurchase != null) { ErrorMessage.INVALID_AMOUNT_FORMAT }
        require(inputPurchase >= 1000) { ErrorMessage.INVALID_AMOUNT_RANGE }
        require(inputPurchase % 1000 == 0) { ErrorMessage.INVALID_AMOUNT_UNIT }
    }

    fun validateInputBonusNumber(number: String, winningNumbers: List<Int>) {
        val bonusNumber = number.toIntOrNull()
        require(!winningNumbers.contains(bonusNumber)) { ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE }
        require(bonusNumber != null) { ErrorMessage.INVALID_BONUS_NUMBER_FORMAT }
        require(bonusNumber in 1..45) { ErrorMessage.INVALID_BONUS_NUMBER_RANGE }
    }
}