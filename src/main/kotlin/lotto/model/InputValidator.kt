package lotto.model

import lotto.message.ErrorMessage

object InputValidator {

    fun validateInputPrice(purchase: String) {
        val inputPurchase = purchase.toIntOrNull()
        require(inputPurchase != null) { ErrorMessage.AMOUNT_IS_NOT_NUMBER.formattedText() }
        require(inputPurchase > 1000) { ErrorMessage.AMOUNT_IS_LESS_THAN_ONE_THOUSAND.formattedText() }
        require(inputPurchase % 1000 == 0) { ErrorMessage.AMOUNT_IS_NOT_DIVISIBLE_BY_THOUSAND.formattedText() }
    }
}
