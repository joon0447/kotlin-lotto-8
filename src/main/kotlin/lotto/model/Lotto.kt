package lotto.model

class Lotto(private val numbers: List<Int>) {

    var bonusNumber: Int? = null
        private set

    fun setBonusNumber(bonusNumber: Int) {
        this.bonusNumber = bonusNumber
    }

    fun calculateWinner(lottos: List<List<Int>>): Map<String, Int> {

    }
}