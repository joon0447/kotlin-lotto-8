package lotto.controller

import lotto.model.InputParser
import lotto.util.InputValidator
import lotto.model.Lotto
import lotto.model.MyLotto
import lotto.model.ProfitCalculator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {

    fun run() {
        val purchaseAmount = readPurchaseAmount()
        val myLotto = createMyLotto(purchaseAmount)
        val lotto = createWinningLotto()
        val bonusNumber = readBonusNumber(lotto.getWinningNumbers())
        val winningResults = calculateWinningResult(lotto, myLotto, bonusNumber)
        printResults(purchaseAmount, winningResults)
    }

    private fun printResults(purchaseAmount: String, winningResults: Map<String, Int>) {
        OutputView.printWinningStatistics(winningResults)
        val profit = ProfitCalculator.calculateProfit(purchaseAmount.toInt(), winningResults)
        OutputView.printProfit(profit.toDouble())
    }

    private fun readPurchaseAmount(): String {
        val purchaseAmount = InputView.inputPurchaseAmount()
        InputValidator.validateInputPrice(purchaseAmount)
        return purchaseAmount
    }

    private fun readBonusNumber(parseWinningNumbers: List<Int>): String {
        val bonusNumber = InputView.inputBonusNumber()
        InputValidator.validateInputBonusNumber(bonusNumber, parseWinningNumbers)
        return bonusNumber
    }


    private fun createMyLotto(purchaseAmount: String): MyLotto {
        val myLotto = MyLotto()
        myLotto.createLottos(purchaseAmount)
        OutputView.printLottoCount(myLotto.getLottos().size)
        OutputView.printLottosNumber(myLotto.getLottos())
        return myLotto
    }

    private fun createWinningLotto(): Lotto {
        val rawWinningNumbers = InputView.inputWinningNumbers()
        val parseWinningNumbers = InputParser.parseWinningNumbers(rawWinningNumbers)
        return Lotto(parseWinningNumbers)
    }

    private fun calculateWinningResult(lotto: Lotto, myLotto: MyLotto, bonusNumber: String): Map<String, Int> {
        return lotto.calculateWinningResults(myLotto.getLottos(), bonusNumber.toInt())
    }
}
