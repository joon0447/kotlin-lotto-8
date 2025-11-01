package lotto.constant.message

enum class OutputMessage(val text: String) {
    PURCHASE_LOTTO_COUNT("개를 구매했습니다.\n"),
    START_WINNING_STATISTICS("\n당첨 통계\n"),
    WINNING_STATISTICS_DIVIDER("---\n"),
    PROFIT("총 수익률은 %s%%입니다.\n");

    fun formattedProfitText(profit: Double): String {
        return text.format(profit)
    }

    override fun toString(): String = text

    companion object {
        fun formattedStatistics(match: Int, prizeMoney: Int, count: Int, bonus: Boolean = false): String {
            val bonusText = if (bonus) ", 보너스 볼 일치" else ""
            val formattedPrize = "%,d".format(prizeMoney)
            return "%d개 일치%s (%s원) - %d개\n".format(match, bonusText, formattedPrize, count)
        }
    }
}
