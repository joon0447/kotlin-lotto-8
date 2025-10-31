package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        InputValidator.validateInputWinningNumber(numbers)
    }
}