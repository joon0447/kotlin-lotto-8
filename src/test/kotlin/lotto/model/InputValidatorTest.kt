package lotto.model

import lotto.constant.message.ErrorMessage
import lotto.util.InputValidator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {

    @Test
    fun `입력된 구입 금액이 정상입력일 때`() {
        assertDoesNotThrow { InputValidator.validateInputPrice("2000") }
    }

    @Test
    fun `입력된 구입 금액이 1000원으로 나누어 떨어지지 않을 때`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputPrice("1500")
        }
        assertEquals(ErrorMessage.INVALID_AMOUNT_UNIT.formattedText(), exception.message)
    }

    @Test
    fun `입력된 구입 금액이 1000원보다 작을 때`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputPrice("500")
        }
        assertEquals(ErrorMessage.INVALID_AMOUNT_RANGE.formattedText(), exception.message)
    }

    @Test
    fun `입력된 구입 금액이 숫자로 변환이 안될 때`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputPrice("1205d")
        }
        assertEquals(ErrorMessage.INVALID_AMOUND_FORMAT.formattedText(), exception.message)
    }

    @Test
    fun `당첨 번호 정상 입력 시`() {
        val input = mutableListOf(1, 2, 3, 4, 5, 6)
        assertDoesNotThrow { InputValidator.validateInputWinningNumber(input) }
    }

    @Test
    fun `입력된 당첨 번호가 6개가 아닐 때`() {
        val input = mutableListOf(1, 2, 3, 4, 5)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputWinningNumber(input)
        }
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.formattedText(), exception.message)
    }

    @Test
    fun `입력된 당첨 번호 중 범위를 벗어난 값이 있을 때`() {
        val input = mutableListOf(1, 2, 106, 4, 5, -4)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputWinningNumber(input)
        }
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.formattedText(), exception.message)
    }

    @Test
    fun `입력된 당첨 번호 중 중복된 값이 있을 때`() {
        val input = mutableListOf(1,1,2,3,4,5)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputWinningNumber(input)
        }
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_DUPLICATE.formattedText(), exception.message)
    }

    @Test
    fun `보너스 번호 정상 입력했을 때`() {
        val winningNumbers = listOf(1,2,3,4,5,6)
        assertDoesNotThrow { InputValidator.validateInputBonusNumber("3", winningNumbers) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "ds4"])
    fun `보너스 번호가 숫자가 아닐 때`(input: String) {
        val winningNumbers = listOf(1,2,3,4,5,6)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputBonusNumber(input, winningNumbers)
        }
        assertEquals(
            ErrorMessage.INVALID_BONUS_NUMBER_FORMAT.formattedText(),
            exception.message
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["-4", "100"])
    fun `보너스 번호가 정상 범위가 아닐 때`(input: String) {
        val winningNumbers = listOf(1,2,3,4,5,6)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputBonusNumber(input, winningNumbers)
        }
        assertEquals(
            ErrorMessage.INVALID_BONUS_NUMBER_RANGE.formattedText(),
            exception.message
        )
    }

    @Test
    fun `당첨 번호에 있는 번호가 보너스번호로 입력될 때`() {
        val winningNumbers = listOf(1,2,3,4,5,6)
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputBonusNumber("1", winningNumbers)
        }
        assertEquals(
            ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE.formattedText(),
            exception.message
        )
    }
}
