package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.message.InputMessage

object InputView {

    private fun inputValue(message: InputMessage): String {
        println(message.text)
        return Console.readLine()
    }

    fun inputPurchaseAmount(): String = inputValue(InputMessage.PURCHASE_AMOUNT)
    fun inputWinningNumbers(): String = inputValue(InputMessage.WINNING_NUMBERS)
    fun inputBonusNumber(): String = inputValue(InputMessage.BONUS_NUMBER)
}
