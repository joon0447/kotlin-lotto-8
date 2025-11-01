package lotto.view

import lotto.constant.Key
import lotto.constant.message.OutputMessage

object OutputView {

    fun printLottoCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun printLottosNumber(lottos: List<List<Int>>) {
        val lottoNumbers = StringBuilder()
        lottos.forEach { lotto ->
            lottoNumbers.append("$lotto\n")
        }
        println(lottoNumbers.toString())
    }

    fun printWinningStatistics(winningStatistics: Map<String, Int>) {
        val printResult = StringBuilder()
        val messages = listOf(
            Key.FIFTH to OutputMessage.WINNING_FIFTH,
            Key.FOURTH to OutputMessage.WINNING_FOURTH,
            Key.THIRD to OutputMessage.WINNING_THIRD,
            Key.SECOND to OutputMessage.WINNING_SECOND,
            Key.FIRST to OutputMessage.WINNING_FIRST
        )
        printResult.append(OutputMessage.START_WINNING_STATISTICS.text)
        printResult.append(OutputMessage.WINNING_STATISTICS_DIVIDER.text)
        messages.forEach { (key, message) ->
            printResult.append(message.formattedText(winningStatistics.getOrDefault(key.value, 0)))
        }
        println(printResult.toString())
    }

    fun printProfit(profit: Double) {
        println("총 수익률은 $profit%입니다.")
    }
}