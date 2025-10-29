package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.message.InputMessage

object InputView {

    fun inputPurchaseAmount(): String {
        println(InputMessage.PURCHASE_AMOUNT.text)
        return Console.readLine()
    }
}
