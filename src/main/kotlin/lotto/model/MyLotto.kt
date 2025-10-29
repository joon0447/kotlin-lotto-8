package lotto.model

import camp.nextstep.edu.missionutils.Randoms

class MyLotto {
    private val myLottos = mutableListOf<String>()

    companion object {
        private const val LOTTO_PRICE = 1000

        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6
    }

    fun createLottos(amount: String) {
        val inputAmount = amount.toInt()
        val lottoCount = inputAmount / LOTTO_PRICE
        repeat(lottoCount) {
            val lottoNumbers = Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBER_COUNT)
            myLottos.add(lottoNumbers.joinToString(",").trim())
        }
    }

    fun getLottos(): List<String> {
        return myLottos
    }
}
