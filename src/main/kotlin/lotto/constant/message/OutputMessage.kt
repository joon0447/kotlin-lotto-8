package lotto.constant.message

enum class OutputMessage(val text: String) {
    PURCHASE_LOTTO_COUNT("개를 구매했습니다.\n"),
    START_WINNING_STATISTICS("\n당첨 통계\n"),
    WINNING_STATISTICS_DIVIDER("---\n"),
    WINNING_FIFTH("3개 일치 (5,000원)"),
    WINNING_FOURTH("4개 일치 (50,000원)"),
    WINNING_THIRD("5개 일치 (1,500,000원)"),
    WINNING_SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    WINNING_FIRST("6개 일치 (2,000,000,000원)"),
    PROFIT("총 수익률은 %s%%입니다.\n");

    fun formattedText(count: Int): String {
        return "$text - ${count}개\n"
    }

    fun formattedProfitText(profit: Double): String {
        return text.format(profit)
    }
}