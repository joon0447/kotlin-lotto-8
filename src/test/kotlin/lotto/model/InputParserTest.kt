package lotto.model

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class InputParserTest {

    @Test
    fun `정상적인 당첨 번호 입력`() {
        val answer = mutableListOf("1", "2", "3", "4", "5", "6")
        assertEquals(
            answer,
            InputParser.parseWinningNumbers("1,2,3,4,5,6")
        )
    }

    @Test
    fun `빈 값 입력`() {
        val answer = mutableListOf("")
        assertEquals(answer,
            InputParser.parseWinningNumbers(""))
    }

    @Test
    fun `정상 입력값 사이에 빈 값 입력`() {
        val answer = mutableListOf("1", "", "2", "3", "4", "5")
        assertEquals(answer,
            InputParser.parseWinningNumbers("1,,2,3,4,5"))
    }
}
