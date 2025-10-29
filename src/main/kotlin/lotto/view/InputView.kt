package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.message.InputMessage

object InputView {

    fun inputPrice(): String {
        println(InputMessage.PRICE.text)
        return Console.readLine()
    }
}
