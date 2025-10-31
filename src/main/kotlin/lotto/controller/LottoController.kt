package lotto.controller

import lotto.model.InputParser
import lotto.model.InputValidator
import lotto.model.Lotto
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

        val rawWinningNumbers = InputView.inputWinningNumbers()
        val parseWinningNumbers = InputParser.parseWinningNumbers(rawWinningNumbers)
        InputValidator.validateInputWinningNumber(parseWinningNumbers)
        val lotto = Lotto(parseWinningNumbers)

        val bonusNumber = InputView.inputBonusNumber()
        InputValidator.validateInputBonusNumber(bonusNumber, parseWinningNumbers)
        lotto.setBonusNumber(bonusNumber.toInt())
        lotto.calculateWinner(myLotto.getLottos())
    }
}
