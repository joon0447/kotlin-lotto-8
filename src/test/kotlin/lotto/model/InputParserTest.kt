package lotto.model

import lotto.constant.message.ErrorMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertIterableEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.assertThrows

class InputParserTest {

    @Test
    fun `정상적인 당첨 번호 입력`() {
        val answer = mutableListOf("1", "2", "3", "4", "5", "6")
        assertIterableEquals(answer, answer)
    }

    @Test
    fun `빈 값 입력`() {
        val exception = assertThrows(IllegalArgumentException::class.java){
            InputParser.parseWinningNumbers("")
        }
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.formattedText(), exception.message)
    }

    @Test
    fun `정상 입력값 사이에 빈 값 입력`() {
        val exception = assertThrows(IllegalArgumentException::class.java){
            InputParser.parseWinningNumbers("1,,2,3,4,5")
        }
        assertEquals(ErrorMessage.INVALID_WINNING_NUMBERS_FORMAT.formattedText(), exception.message)
    }
}
