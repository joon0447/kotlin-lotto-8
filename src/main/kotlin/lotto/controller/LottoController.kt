package lotto.controller

import lotto.model.InputValidator
import lotto.model.MyLotto
import lotto.view.InputView

class LottoController {

    fun run() {
        val purchaseAmount = InputView.inputPurchaseAmount()
        InputValidator.validateInputPrice(purchaseAmount)

        val myLotto = MyLotto()
        myLotto.createLottos(purchaseAmount)
    }
}
