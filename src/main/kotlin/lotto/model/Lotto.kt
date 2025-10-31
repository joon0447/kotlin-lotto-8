package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        InputValidator.validateInputWinningNumber(numbers)
    }

    var bonusNumber: Int? = null
        private set

    fun setBonusNumber(bonusNumber: Int) {
        this.bonusNumber = bonusNumber
    }
}