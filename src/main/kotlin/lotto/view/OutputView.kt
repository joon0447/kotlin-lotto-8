package lotto.view

object OutputView {

    fun printLottoCount(count: Int) {
        println("${count}개를 구매했습니다.")
    }

    fun printLottosNumber(lottos: List<String>) {
        val lottoNumbers = StringBuilder()
        lottos.forEach { lotto ->
            lottoNumbers.append("[$lotto]\n")
        }
        println(lottoNumbers.toString())
    }
}