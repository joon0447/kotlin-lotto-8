package lotto.model

import lotto.message.ErrorMessage

object InputValidator {

    fun validateInputPrice(purchase: String) {
        val inputPurchase = purchase.toIntOrNull()
        require(inputPurchase != null) { ErrorMessage.INVALID_AMOUND_FORMAT.formattedText() }
        require(inputPurchase > 1000) { ErrorMessage.INVALID_AMOUNT_RANGE.formattedText() }
        require(inputPurchase % 1000 == 0) { ErrorMessage.INVALID_AMOUNT_UNIT.formattedText() }
    }
}
