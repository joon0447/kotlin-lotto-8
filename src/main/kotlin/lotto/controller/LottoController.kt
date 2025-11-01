package lotto.controller

import lotto.constant.Rank
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

    private fun printResults(purchaseAmount: String, winningResults: Map<Rank, Int>) {
        OutputView.printWinningStatistics(winningResults)
        val profit = ProfitCalculator.calculateProfit(purchaseAmount.toInt(), winningResults)
        OutputView.printProfit(profit.toDouble())
    }

    private fun readPurchaseAmount(): String {
        while (true) {
            try {
                val purchaseAmount = InputView.inputPurchaseAmount()
                InputValidator.validateInputPrice(purchaseAmount)
                return purchaseAmount
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun readBonusNumber(parseWinningNumbers: List<Int>): String {
        while (true) {
            try {
                val bonusNumber = InputView.inputBonusNumber()
                InputValidator.validateInputBonusNumber(bonusNumber, parseWinningNumbers)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun createMyLotto(purchaseAmount: String): MyLotto {
        val myLotto = MyLotto()
        myLotto.createLottos(purchaseAmount)
        OutputView.printLottoCount(myLotto.getLottos().size)
        OutputView.printLottosNumber(myLotto.getLottos())
        return myLotto
    }

    private fun createWinningLotto(): Lotto {
        while (true) {
            try {
                val rawWinningNumbers = InputView.inputWinningNumbers()
                val parseWinningNumbers = InputParser.parseWinningNumbers(rawWinningNumbers)
                return Lotto(parseWinningNumbers)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun calculateWinningResult(lotto: Lotto, myLotto: MyLotto, bonusNumber: String): Map<Rank, Int> {
        return lotto.calculateWinningResults(myLotto.getLottos(), bonusNumber.toInt())
    }
}
