package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.constant.LottoRule

class MyLotto {
    private val myLottos = mutableListOf<List<Int>>()

    fun createLottos(amount: String) {
        val inputAmount = amount.toInt()
        val lottoCount = inputAmount / LottoRule.PURCHASE_AMOUNT_UNIT
        repeat(lottoCount) {
            val lottoNumbers = Randoms.pickUniqueNumbersInRange(
                LottoRule.MIN_WINNING_NUMBER,
                LottoRule.MAX_WINNING_NUMBER,
                LottoRule.WINNING_NUMBERS_SIZE)
            myLottos.add(lottoNumbers.sorted())
        }
    }

    fun getLottos(): List<List<Int>> {
        return myLottos
    }
}
