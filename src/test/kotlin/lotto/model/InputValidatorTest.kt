package lotto.model

import lotto.message.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

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
        assertEquals(ErrorMessage.INVALID_AMOUNT_UNIT.text, exception.message)
    }

    @Test
    fun `입력된 구입 금액이 1000원보다 작을 때`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputPrice("500")
        }
        assertEquals(ErrorMessage.INVALID_AMOUNT_RANGE.text, exception.message)
    }

    @Test
    fun `입력된 구입 금액이 숫자로 변환이 안될 때`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputPrice("1205d")
        }
        assertEquals(ErrorMessage.INVALID_AMOUND_FORMAT.text, exception.message)
    }

    @Test
    fun `당첨 번호 정상 입력 시`() {
        val input = mutableListOf("1", "2", "3", "4", "5", "6")
        assertDoesNotThrow { InputValidator.validateInputWinningNumber(input) }
    }

    @Test
    fun `입력된 당첨 번호가 6개가 아닐 때`() {
        val input = mutableListOf("1", "2", "3", "4", "5")
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputWinningNumber(input)
        }
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_COUNT.formattedText(), exception.message)
    }

    @Test
    fun `입력된 당첨 번호 중 범위를 벗어난 값이 있을 때`() {
        val input = mutableListOf("1", "2", "3", "104", "5", "6")
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputWinningNumber(input)
        }
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.formattedText(), exception.message)
    }
}
