package lotto.model

import lotto.constant.message.ErrorMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.assertThrows

class InputParserTest {

    @Test
    fun `정상적인 당첨 번호를 입력하면 예외가 발생하지 않는다`() {
        val answer = mutableListOf("1", "2", "3", "4", "5", "6")
        assertIterableEquals(answer, answer)
    }

    @Test
    fun `당첨 번호에 빈 값만 입력하면 당첨 번호 포맷 에러 메시지가 출력된다`() {
        val exception = assertThrows(IllegalArgumentException::class.java){
            InputParser.parseWinningNumbers("")
        }
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.toString(), exception.message)
    }

    @Test
    fun `당첨 번호에 빈 값이 포함되면 당첨 번호 포맷 에러 메시지가 출력된다`() {
        val exception = assertThrows(IllegalArgumentException::class.java){
            InputParser.parseWinningNumbers("1,,2,3,4,5")
        }
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.toString(), exception.message)
    }
}
