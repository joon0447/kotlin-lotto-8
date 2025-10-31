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
        printResult.append(OutputMessage.START_WINNING_STATISTICS.text)
        printResult.append(OutputMessage.WINNING_STATISTICS_DIVIDER.text)
        printResult.append(OutputMessage.WINNING_FIFTH.formattedText(winningStatistics.getOrDefault(Key.FIFTH.value, 0)))
        printResult.append(OutputMessage.WINNING_FOURTH.formattedText(winningStatistics.getOrDefault(Key.FOURTH.value, 0)))
        printResult.append(OutputMessage.WINNING_THIRD.formattedText(winningStatistics.getOrDefault(Key.THIRD.value, 0)))
        printResult.append(OutputMessage.WINNING_SECOND.formattedText(winningStatistics.getOrDefault(Key.SECOND.value, 0)))
        printResult.append(OutputMessage.WINNING_FIRST.formattedText(winningStatistics.getOrDefault(Key.FIRST.value, 0)))
        println(printResult.toString())
    }
}