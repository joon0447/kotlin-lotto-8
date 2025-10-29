package lotto.model

import lotto.message.ErrorMessage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class InputValidatorTest {

    @Test
    fun `입력된 구입 금액이 정상입력일 때`() {
        assertDoesNotThrow { InputValidator.validateInputPrice(2000) }
    }

    @Test
    fun `입력된 구입 금액이 1000원으로 나누어 떨어지지 않을 때`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputPrice(150)
        }
        assertEquals(ErrorMessage.AMOUNT_IS_NOT_DIVISIBLE_BY_THOUSAND, exception.message)
    }

    @Test
    fun `입력된 구입 금액이 0보다 작을 때`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputPrice(-1500)
        }
        assertEquals(ErrorMessage.AMOUNT_IS_MINUS, exception.message)
    }

    @Test
    fun `입력된 구입 금액이 숫자로 변환이 안될 때`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            InputValidator.validateInputPrice(-1500)
        }
        assertEquals(ErrorMessage.AMOUNT_IS_NOT_NUMBER, exception.message)
    }
}
