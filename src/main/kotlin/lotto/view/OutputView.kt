package lotto.view

import lotto.constant.Rank
import lotto.constant.message.OutputMessage

object OutputView {

    fun printLottoCount(count: Int) {
        println("$count${OutputMessage.PURCHASE_LOTTO_COUNT.text}")
    }

    fun printLottosNumber(lottos: List<List<Int>>) {
        val lottoNumbers = StringBuilder()
        lottos.forEach { lotto ->
            lottoNumbers.append("$lotto\n")
        }
        println(lottoNumbers.toString())
    }

    fun printWinningStatistics(winningStatistics: Map<Rank, Int>) {
        val printResult = StringBuilder()
        val messages = listOf(
            Rank.FIFTH to OutputMessage.WINNING_FIFTH,
            Rank.FOURTH to OutputMessage.WINNING_FOURTH,
            Rank.THIRD to OutputMessage.WINNING_THIRD,
            Rank.SECOND to OutputMessage.WINNING_SECOND,
            Rank.FIRST to OutputMessage.WINNING_FIRST
        )
        printResult.append(OutputMessage.START_WINNING_STATISTICS.text)
        printResult.append(OutputMessage.WINNING_STATISTICS_DIVIDER.text)
        messages.forEach { (rank, message) ->
            printResult.append(message.formattedText(winningStatistics.getOrDefault(rank, 0)))
        }
        println(printResult.toString())
    }

    fun printProfit(profit: Double) {
        println(OutputMessage.PROFIT.formattedProfitText(profit))
    }
}