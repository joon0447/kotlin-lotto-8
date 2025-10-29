package lotto.controller

import lotto.model.InputValidator
import lotto.model.MyLotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        val purchaseAmount = InputView.inputPurchaseAmount()
        InputValidator.validateInputPrice(purchaseAmount)

        val myLotto = MyLotto()
        myLotto.createLottos(purchaseAmount)
        OutputView.printLottoCount(myLotto.getLottos().size)
        OutputView.printLottosNumber(myLotto.getLottos())
    }
}
