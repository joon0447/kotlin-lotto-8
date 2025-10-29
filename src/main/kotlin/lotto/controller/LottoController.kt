package lotto.controller

import lotto.view.InputView

class LottoController {

    fun run() {
        val price = InputView.inputPrice()
        println(price)
    }
}
