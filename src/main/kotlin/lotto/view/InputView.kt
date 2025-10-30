package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.message.InputMessage

object InputView {

    fun inputPurchaseAmount(): String {
        println(InputMessage.PURCHASE_AMOUNT.text)
        return Console.readLine()
    }

    fun inputWinningNumbers(): String {
        println(InputMessage.WINNING_NUMBERS.text)
        return Console.readLine()
    }
}
