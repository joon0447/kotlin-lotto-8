package lotto.util

import lotto.constant.message.ErrorMessage
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @Test
    fun `입력된 구입 금액이 정상적으로 입력되면 예외가 발생하지 않는다`() {
        assertDoesNotThrow { InputValidator.validateInputPrice("2000") }
    }

    @Test
    fun `입력된 구입 금액이 1000원으로 나누어 떨어지지 않을 때 INVALID_AMOUNT_UNIT 메시지가 출력된다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputPrice("1500")
        }
        Assertions.assertEquals(ErrorMessage.INVALID_AMOUNT_UNIT.toString(), exception.message)
    }

    @Test
    fun `입력된 구입 금액이 1000원보다 작을 때 INVALID_AMOUNT_RANGE 메시지가 출력된다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputPrice("500")
        }
        Assertions.assertEquals(ErrorMessage.INVALID_AMOUNT_RANGE.toString(), exception.message)
    }

    @Test
    fun `입력된 구입 금액이 숫자로 변환이 안될 때 INVALID_AMOUNT_FORMAT 메시지가 출력된다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputPrice("1205d")
        }
        Assertions.assertEquals(ErrorMessage.INVALID_AMOUNT_FORMAT.toString(), exception.message)
    }

    @Test
    fun `보너스 번호가 당첨 번호에 포함되어 있을 경우 INVALID_BONUS_NUMBER_DUPLICATE 메시지가 출력된다`() {
        val winningNumbers = listOf(1,2,3,4,5,6)
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputBonusNumber("3", winningNumbers)
        }
        Assertions.assertEquals(
            ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE.toString(),
            exception.message
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "ds4"])
    fun `보너스 번호가 숫자가 아닐 때 INVALID_BONUS_NUMBER_FORMAT 메시지가 출력된다`(input: String) {
        val winningNumbers = listOf(1,2,3,4,5,6)
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputBonusNumber(input, winningNumbers)
        }
        Assertions.assertEquals(
            ErrorMessage.INVALID_BONUS_NUMBER_FORMAT.toString(),
            exception.message
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["-4", "100"])
    fun `보너스 번호가 1 ~ 45 범위가 아닐 때 INVALID_BONUS_NUMBER_RANGE 메시지가 출력된다`(input: String) {
        val winningNumbers = listOf(1,2,3,4,5,6)
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputBonusNumber(input, winningNumbers)
        }
        Assertions.assertEquals(
            ErrorMessage.INVALID_BONUS_NUMBER_RANGE.toString(),
            exception.message
        )
    }
}