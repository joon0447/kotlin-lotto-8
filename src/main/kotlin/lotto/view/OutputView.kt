package lotto.view

import lotto.constant.Rank
import lotto.constant.message.OutputMessage

object OutputView {

    fun printLottoCount(count: Int) {
        println("$count${OutputMessage.PURCHASE_LOTTO_COUNT}")
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

        printResult.append(OutputMessage.START_WINNING_STATISTICS)
        printResult.append(OutputMessage.WINNING_STATISTICS_DIVIDER)

        winningStatistics
            .forEach { (rank, count) ->
            printResult.append(
                OutputMessage.formattedStatistics(
                    rank.match,
                    rank.prizeMoney,
                    count,
                    rank.bonus
                )
            )
        }
        println(printResult.toString())
    }

    fun printProfit(profit: Double) {
        println(OutputMessage.PROFIT.formattedProfitText(profit))
    }
}