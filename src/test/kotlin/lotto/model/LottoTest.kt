package lotto.model

import lotto.message.ErrorMessage
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @Test
    fun `로또 번호 정상 입력하면 예외가 발생하지 않는다`() {
        assertDoesNotThrow { Lotto(listOf(1, 2, 3, 4, 5, 6)) }
    }

    @Test
    fun `로또 번호 중 범위를 벗어난 값이 있으면 예외가 발생한다`() {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            Lotto(listOf(1,2,3,-50,100,6))
        }
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_RANGE.formattedText(), exception.message)
    }
}
